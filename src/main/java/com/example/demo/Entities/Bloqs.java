package com.example.demo.Entities;


import com.example.demo.Enums.AnounceStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "bloqs",indexes = {
		  @Index(name = "idx_bloqs_title",columnList = "title"),
		  @Index(name = "idx_bloqs_sharing_date",columnList = "sharing_date"),
		  @Index(name = "idx_bloqs_status",columnList = "status")
})
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bloqs {

@Id
@Column(name = "id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(name = "title")
private String title;

@Column(name = "news_txt")
private String newsTxt;

@Column(name = "bloqs")
private Boolean bloqs; //Burada truedirse bloq falsedirse meqaledir

@Column(name = "sharing_date")
private LocalDateTime sharingDate;

@Column(name = "status")
@Enumerated(EnumType.STRING)
private AnounceStatus status;

@Column(name = "sosial_medias")
private String sosialMedias;

@Column(name = "comment")
private String comment; // status deyisdikde burada sebebi qeyd olunacaq
}
