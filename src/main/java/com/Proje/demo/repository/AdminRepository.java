package com.Proje.demo.repository;

import com.Proje.demo.entity.AdminInfo;
import com.Proje.demo.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<AdminInfo, Long> {
    Optional<AdminInfo> findByUsername(String username);
}