package com.example.reservationservice.controller;

import com.example.reservationservice.model.Reservation;
import com.example.reservationservice.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/reservations/")
public class ReservationController {

    private final ReservationService reservationService;
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<Reservation> getReservations() {
        return reservationService.getReservations();
    }
    @GetMapping("{id}")
    public Reservation getReservationById(@PathVariable Long id) {
        return reservationService.getReservationById(id);
    }
    @PostMapping
    public Reservation  addReservation(@RequestBody Reservation Reservation) {
        return reservationService.saveReservation(Reservation);
    }
    @PutMapping
    public Reservation  updateReservation(@RequestBody Reservation Reservation) {
        return reservationService.updateReservation(Reservation);
    }
    @DeleteMapping("{id}")
    public String  deleteReservation(@PathVariable Long id) {
        return reservationService.deleteReservationById(id);
    }
}
