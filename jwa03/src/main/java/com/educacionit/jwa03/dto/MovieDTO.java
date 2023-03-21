package com.educacionit.jwa03.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {
	private Integer id;
	private String name;
	private String summary;
	private String cover;
	
}
