package com.example.reservationservice.service;

import com.example.reservationservice.model.Reservation;
import com.example.reservationservice.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService{
    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public List<Reservation> getReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).get();
    }

    @Override
    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation updateReservation(Reservation newReservation) {

        if(reservationRepository.findById(newReservation.getId()).isPresent())
        {
            Reservation updatedReservation = reservationRepository.findById(newReservation.getId()).get();

            if(newReservation.getReturnDate() != null) updatedReservation.setReturnDate(newReservation.getReturnDate());
            if(newReservation.getReservationDate() != null) updatedReservation.setReservationDate(newReservation.getReservationDate());
            return reservationRepository.save(newReservation);
        }
        return null;
    }

    @Override
    public String deleteReservationById(Long id) {
        if(reservationRepository.findById(id).isPresent())
        {
            reservationRepository.deleteById(id);
            return "Successfully deleted";
        }
        return "No reservation with the provided ID";
    }
}
