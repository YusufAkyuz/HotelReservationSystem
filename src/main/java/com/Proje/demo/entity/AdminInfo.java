package com.Proje.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "AdminInfo")
public class AdminInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "admin_id")
    private Long id;
    @Column(name = "admin_username")
    private String username;
    @Column(name = "admin_password")
    private String password;


    public AdminInfo() {

    }
    public AdminInfo(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
