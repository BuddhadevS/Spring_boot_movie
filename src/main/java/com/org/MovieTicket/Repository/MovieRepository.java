package com.org.MovieTicket.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.MovieTicket.Dto.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>{
	List<Movie> findByReleaseDate(LocalDate movieDate);
}
