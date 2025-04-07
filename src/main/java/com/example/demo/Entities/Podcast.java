package com.example.demo.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "podcast")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Podcast {

@Id
@Column(name = "id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(name = "title")
private String title;

@Column(name = "movie_link")
private String movieLink;

@Column(name = "sharing_date")
private LocalDateTime sharingDate;


}
