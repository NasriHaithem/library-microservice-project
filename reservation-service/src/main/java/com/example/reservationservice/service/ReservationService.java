package com.example.reservationservice.service;

import com.example.reservationservice.model.Reservation;

import java.util.List;

public interface ReservationService {
    public List<Reservation> getReservations();
    public Reservation getReservationById(Long id);
    public Reservation saveReservation(Reservation reservation);
    public Reservation updateReservation(Reservation reservation);
    public String deleteReservationById(Long id);
}
