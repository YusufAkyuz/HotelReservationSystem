package com.Proje.demo.repository;

import com.Proje.demo.entity.AdminReservationInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminReservationRepository extends JpaRepository<AdminReservationInfo, Long> {

}
