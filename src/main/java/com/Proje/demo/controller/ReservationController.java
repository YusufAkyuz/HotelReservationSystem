package com.Proje.demo.controller;


import com.Proje.demo.entity.ReservationInfo;
import com.Proje.demo.services.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<ReservationInfo> findAllReservation() {
        return reservationService.findAllReservation();
    }

    @GetMapping("/{id}")
    public Optional<ReservationInfo> findReservationById(@PathVariable("id") Long id) {
        return reservationService.findById(id);
    }

    @PostMapping
    public ReservationInfo saveReservation(@RequestBody ReservationInfo reservationInfo) {
        return reservationService.saveReservation(reservationInfo);
    }

    @PutMapping
    public ReservationInfo updateReservation(@RequestBody ReservationInfo reservationInfo) {
        return reservationService.updateReservation(reservationInfo);
    }

    @DeleteMapping("({id}")
    public void deleteReservation(@PathVariable("id") Long id) {
        reservationService.deleteReservation(id);
    }
}
