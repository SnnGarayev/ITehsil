package com.example.demo.Dtos.OutputDto;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
public class DtoOutputNewsBig {

public DtoOutputNewsBig(
		  Long id, String title, String newsTxt, String firstPhoto,
		  List<String> photos, LocalDateTime sharingDate) {
	 this.id = id;
	 this.title = title;
	 this.newsTxt = newsTxt;
	 this.firstPhoto = firstPhoto;
	 this.photos = photos;
	 this.sharingDate = sharingDate;
}

private Long id;

private String title;

private String newsTxt;

private String firstPhoto;

private List<String> photos;

private LocalDateTime sharingDate;

}
