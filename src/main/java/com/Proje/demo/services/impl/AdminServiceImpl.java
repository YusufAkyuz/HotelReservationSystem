package com.Proje.demo.services.impl;

import com.Proje.demo.entity.AdminInfo;
import com.Proje.demo.repository.AdminRepository;
import com.Proje.demo.services.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }


    @Override
    public List<AdminInfo> findAllAdmin() {
        return adminRepository.findAll();
    }

    @Override
    public Optional<AdminInfo> findById(long id) {
        return adminRepository.findById(id);
    }

    @Override
    public AdminInfo saveAdmin(AdminInfo adminInfo) {
        return adminRepository.save(adminInfo);
    }

    @Override
    public AdminInfo updateAdmin(AdminInfo adminInfo) {
        return adminRepository.save(adminInfo);
    }

    @Override
    public void deleteLocation(Long id) {
        adminRepository.deleteById(id);
    }
}
