package com.example.demo.Dtos.OutputDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoOutputNewsSearching {

public DtoOutputNewsSearching(Long id, String title) {
	 this.id = id;
	 this.title = title;
}

Long id;
String title;
}
