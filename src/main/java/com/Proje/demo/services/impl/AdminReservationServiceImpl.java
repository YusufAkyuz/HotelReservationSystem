package com.Proje.demo.services.impl;

import com.Proje.demo.entity.AdminReservationInfo;
import com.Proje.demo.entity.ReservationInfo;
import com.Proje.demo.entity.UserInfo;
import com.Proje.demo.repository.AdminReservationRepository;
import com.Proje.demo.services.AdminReservationService;
import com.Proje.demo.services.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class AdminReservationServiceImpl implements AdminReservationService {


    private final AdminReservationRepository adminReservationRepository;

    public AdminReservationServiceImpl(AdminReservationRepository adminReservationRepository) {
        this.adminReservationRepository = adminReservationRepository;
    }

    @Override
    public List<AdminReservationInfo> findAllAdminReservationInfo() {
        return adminReservationRepository.findAll();
    }

    @Override
    public AdminReservationInfo createReservation(AdminReservationInfo adminReservationInfo) {
        return adminReservationRepository.save(adminReservationInfo);
    }

    @Override
    public void deleteLocation(Long id) {
        adminReservationRepository.deleteById(id);
    }
}
