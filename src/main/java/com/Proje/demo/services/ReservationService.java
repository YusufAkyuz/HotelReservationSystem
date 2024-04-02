package com.Proje.demo.services;

import com.Proje.demo.entity.LocationInfo;
import com.Proje.demo.entity.ReservationInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ReservationService {

    List<ReservationInfo> findAllReservation();
    Optional<ReservationInfo> findById(long id);
    ReservationInfo saveReservation(ReservationInfo reservationInfo);
    ReservationInfo createReservation(ReservationInfo reservationInfo);
    ReservationInfo updateReservation(ReservationInfo reservationInfo);

    void deleteReservation(Long id);
}
