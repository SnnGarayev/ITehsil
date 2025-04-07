package com.example.demo.Dtos.OutputDto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class DtoOutputNewsComp {

public DtoOutputNewsComp(Long id, String title, String firstPhoto, LocalDateTime sharingDate) {
	 this.id = id;
	 this.title = title;
	 this.firstPhoto = firstPhoto;
	 this.sharingDate = sharingDate;
}

private Long id;

private String title;

private String firstPhoto;

private LocalDateTime sharingDate;
}
