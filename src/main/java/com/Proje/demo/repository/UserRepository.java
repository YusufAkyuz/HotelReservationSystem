package com.Proje.demo.repository;

import com.Proje.demo.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserInfo, Long> {
}
