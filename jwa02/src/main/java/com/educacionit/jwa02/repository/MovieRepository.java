package com.educacionit.jwa02.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.educacionit.jwa02.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>, MovieRepositoryCustom {

	@Query(nativeQuery=true, value = "SELECT id, duration_in_minutes, name, summary, year_of_release FROM movie WHERE year_of_release= :year")
	List<Movie> getAllMoviesByYear(Integer year);

}
