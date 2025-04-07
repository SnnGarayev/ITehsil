package com.example.demo.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CollectionType;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "news",indexes = {
		  @Index(name = "idx_news_title",columnList = "title"),
		  @Index(name = "idx_news_sharing_date",columnList = "sharing_date")
})
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class News {

@Id
@Column(name = "id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(name = "title")
private String title;

@Column(name = "news_txt")
private String newsTxt;

@Column(name = "first_photo")
private String firstPhoto;

@ElementCollection(fetch = FetchType.EAGER)
@CollectionTable(name = "news_photos",joinColumns = @JoinColumn(name = "news_id"))
@Column(name = "photos")
private List<String> photos;

@Column(name = "sharing_date")
private LocalDateTime sharingDate;
}
