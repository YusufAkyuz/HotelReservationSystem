package com.Proje.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "UserInfo")
public class UserInfo {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "user_id")
    private long id;
    @Column(name = "user_mail")
    private String username;
    @Column(name = "user_password")
    private String password;
    @Column(name = "user_role")
    private String role;

    public UserInfo() {

    }
    public UserInfo(String username, String password,String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String mail) {
        this.username = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
