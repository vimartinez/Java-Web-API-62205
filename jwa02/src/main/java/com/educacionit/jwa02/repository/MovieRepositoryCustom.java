package com.educacionit.jwa02.repository;

import java.util.List;

import com.educacionit.jwa02.model.Movie;

public interface MovieRepositoryCustom {
	
	List<Movie> getAllMoviesByYearCriteria(Integer year);
	
	List<Movie> getAllMoviesByYearAndDuration(Integer year, Integer duration);

}
