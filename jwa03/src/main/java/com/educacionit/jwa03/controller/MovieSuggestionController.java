package com.educacionit.jwa03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.educacionit.jwa03.dto.MovieDTO;
import com.educacionit.jwa03.service.MovieSuggestionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/moviesuggestions")
@CrossOrigin
public class MovieSuggestionController {
	
	@Autowired MovieSuggestionService movieSuggestionService;
	
	@Operation(summary="Devuelve un listado de películas", description="ingresar el nombre de la peli")
	@ApiResponses(value = {
		@ApiResponse(responseCode="200", description = "Todo anduvo bien"),	
		@ApiResponse(responseCode="404", description = "No se encontró la peli")
	})
	@GetMapping(value="/", produces= "Application/json")
	public List<MovieDTO> getMoviesByName(@Parameter(description="Nombre de la peli") @RequestParam(value="Nombre", defaultValue="Back to the Future") String movieName){
		return movieSuggestionService.getMoviesByName(movieName);
		
	}

}
