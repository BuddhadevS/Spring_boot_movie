package com.org.MovieTicket.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.MovieTicket.Dto.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer>{

}
