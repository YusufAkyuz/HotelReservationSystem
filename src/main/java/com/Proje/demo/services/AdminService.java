package com.Proje.demo.services;

import com.Proje.demo.entity.AdminInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AdminService {

    List<AdminInfo> findAllAdmin();
    Optional<AdminInfo> findById(long id);
    AdminInfo saveAdmin(AdminInfo adminInfo);
    AdminInfo updateAdmin(AdminInfo adminInfo);
    void deleteLocation(Long id);
}
