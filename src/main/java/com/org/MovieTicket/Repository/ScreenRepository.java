package com.org.MovieTicket.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.MovieTicket.Dto.Screen;

public interface ScreenRepository extends JpaRepository<Screen, Integer>{
	boolean existsByName(String name);
}
