package com.educacionit.jwa02.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educacionit.jwa02.model.Movie;
import com.educacionit.jwa02.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	MovieRepository movieRepository;
	
	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}

	public Movie addMovie(Movie movie) {
		return movieRepository.save(movie);
		
	}

	public Optional<Movie> getMovieById(Long id) {
		return movieRepository.findById(id);
	}

	public void delMovie(Long id) {
		//Agregar validación para verificar que exista la peli antes de eliminarla
		movieRepository.deleteById(id);
		
	}

	public void updMovie(Movie movie) {
		//buscar el objeto con ese id del movie recibido
		//verificar uno a uno los atributos para actualizar solo los que vienen en el objeto nuevo;
		movieRepository.save(movie);
	}

	public List<Movie> getAllMoviesByYear(Integer year) {
		
		return movieRepository.getAllMoviesByYear(year);
	}

	public List<Movie> getAllMoviesByYearCriteria(Integer year) {
		
		return movieRepository.getAllMoviesByYearCriteria(year);
	}

	public List<Movie> getAllMoviesByYearAndDuration(Integer year, Integer duration) {
		
		return movieRepository.getAllMoviesByYearAndDuration(year, duration);
	}

}
