package com.example.demo.Dtos.OutputDto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class DtoOutputPodcast {

public DtoOutputPodcast(Long id, String title, String movieLink, LocalDateTime sharingDate) {
	 this.id = id;
	 this.title = title;
	 this.movieLink = movieLink;
	 this.sharingDate = sharingDate;
}

private Long id;

private String title;

private String movieLink;

private LocalDateTime sharingDate;
}
