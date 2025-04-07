package com.example.demo.Dtos.OutputDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoOutputSubGroup {
public DtoOutputSubGroup(Long id,Long upId, String name) {
	 this.id = id;
	 this.upId = upId;
	 this.name = name;
}

Long id;
Long upId;
String name;
}
