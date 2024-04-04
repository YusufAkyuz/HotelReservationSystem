package com.Proje.demo.repository;

import com.Proje.demo.entity.ReservationInfo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReservationRepository extends JpaRepository<ReservationInfo, Long> {

}
