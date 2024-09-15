package com.org.MovieTicket.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.MovieTicket.Dto.Seat;

public interface SeatRepository extends JpaRepository<Seat, Integer>{
	List<Seat> findBySeatNumberIn(List<String> selectedSeats);
}
