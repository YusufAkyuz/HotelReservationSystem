package com.Proje.demo.services;

import com.Proje.demo.entity.AdminReservationInfo;
import com.Proje.demo.entity.ReservationInfo;
import com.Proje.demo.entity.UserInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminReservationService {
    List<AdminReservationInfo> findAllAdminReservationInfo();
    AdminReservationInfo createReservation(AdminReservationInfo adminReservationInfo);
    void deleteLocation(Long id);
}
