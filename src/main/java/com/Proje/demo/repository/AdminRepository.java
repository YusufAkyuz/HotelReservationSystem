package com.Proje.demo.repository;

import com.Proje.demo.entity.AdminInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminInfo, Long> {
    // private sorgulari ekleyebilecex burya
}