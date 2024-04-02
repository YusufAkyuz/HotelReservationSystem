package com.Proje.demo.controller;

import com.Proje.demo.entity.AdminInfo;
import com.Proje.demo.services.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public List<AdminInfo> findAllAdmin() {
        return adminService.findAllAdmin();
    }

    @GetMapping("/{id}")
    public Optional<AdminInfo> findAdminById(@PathVariable("id") Long id) {
        return adminService.findById(id);
    }

    @PostMapping
    public AdminInfo saveAdmin(@RequestBody AdminInfo adminInfo) {
        return adminService.saveAdmin(adminInfo);
    }

    @PutMapping
    public AdminInfo updateAdmin(@RequestBody AdminInfo adminInfo) {
        return adminService.updateAdmin(adminInfo);
    }

    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable("id") long id) {
        adminService.deleteLocation(id);
    }
}
