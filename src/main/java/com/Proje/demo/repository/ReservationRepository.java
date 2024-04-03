package com.Proje.demo.repository;

import com.Proje.demo.entity.LocationInfo;
import com.Proje.demo.entity.ReservationInfo;
import com.Proje.demo.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<ReservationInfo, Long> {

}
