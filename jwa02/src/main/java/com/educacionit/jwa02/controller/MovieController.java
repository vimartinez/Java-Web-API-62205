package com.educacionit.jwa02.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.educacionit.jwa02.model.Movie;
import com.educacionit.jwa02.service.MovieService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@Autowired
	MovieService movieService;
	
	@GetMapping(value="/")
	@Operation(summary="Devuelve un listado de películas", description="No tiene parámetros de entrada", tags = {"Pelis"})
	@ApiResponses(value= {
			@ApiResponse(responseCode="200", description="Se encontraron pelis"),
			@ApiResponse(responseCode="404", description="No se encontraron pelis en BD")
	})
	public @ResponseBody List<Movie> getAllMovies(){
		return movieService.getAllMovies();
		
	}
	
	@PostMapping(value="/", produces= "application/json")
	@Operation(summary="Dar de alta una película", description="Sumar pelis a nuestra bd", tags = {"Pelis"})
	public @ResponseBody void addMovie(Movie movie){
		movieService.addMovie(movie);
		
	}
	
	@GetMapping(value="/{idMovie}")
	@Operation(summary="Obtener una peli de la base", description="Se debe enviar el id de la película", tags = {"Pelis"})
	public @ResponseBody Optional<Movie> getMovieById(@Parameter(description="id de la película") @PathVariable("idMovie") Long id){
		return movieService.getMovieById(id);
		
	}

	@DeleteMapping(path="/{id}", produces="application/json")
	@Operation(summary="Borrar una peli de la base", description="Se debe enviar el id de la película", tags = {"Pelis"})
	public @ResponseBody void delMovie(@Parameter(description="id de la película") Long id) {
		movieService.delMovie(id);
	}
	
	@PutMapping(path="/", produces="application/json")
	@Operation(summary="Modificar una peli una peli de la base", description="Se debe enviar el id de la película", tags = {"Pelis"})
	public @ResponseBody void UpdMovie(Movie movie) {
		movieService.updMovie(movie);
	}
	
	@GetMapping(value="year/{year}")
	@Operation(summary="Obtener un listado de películas según el año de estreno", description="Se debe enviar el año de la peli", tags = {"Consultas Personalizadas"})
	public @ResponseBody List<Movie> getAllMoviesByYear(@Parameter(description="Año de estreno de la peli") Integer year){
		return movieService.getAllMoviesByYear(year);
		
	}
	
	@GetMapping(value="yearcriteria/{year}")
	@Operation(summary="Obtener un listado de películas según el año de estreno", description="Se debe enviar el año de la peli", tags = {"Consultas Personalizadas"})
	public @ResponseBody List<Movie> getAllMoviesByYearCriteria(@Parameter(description="Año de estreno de la peli") Integer year){
		return movieService.getAllMoviesByYearCriteria(year);
		
	}
	
	@GetMapping(value="yearandduration/")
	@Operation(summary="Obtener un listado de películas según el año de estreno y la duración", description="Se debe enviar el año de la peli y la duración en minutos", tags = {"Consultas Personalizadas"})
	public @ResponseBody List<Movie> getallMoviesByYearAndDuration(@RequestParam("year") Integer year, @RequestParam("duration") Integer duration) {
		return movieService.getAllMoviesByYearAndDuration(year, duration);
		
	}
}
