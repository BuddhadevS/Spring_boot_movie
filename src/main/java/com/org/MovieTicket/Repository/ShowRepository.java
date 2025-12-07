package com.org.MovieTicket.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.MovieTicket.Dto.Movie;
import com.org.MovieTicket.Dto.Screen;
import com.org.MovieTicket.Dto.Show;

public interface ShowRepository extends JpaRepository<Show, Integer>{
	
	List<Show> findByScreenIn(List<Screen> screens);

    boolean existsByScreenAndTimingAndAvailableTrueAndMovieIn(Screen screen, int timing, List<Movie> movies);

    List<Show> findByMovieAndAvailableTrue(Movie movie);

}
