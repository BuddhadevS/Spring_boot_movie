package com.org.MovieTicket.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.MovieTicket.Dto.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>{

}
