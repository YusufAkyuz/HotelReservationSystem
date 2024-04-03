package com.Proje.demo.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "RezervationInfo")
public class ReservationInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rezervation_user_id")
    private Long userId;
    @Column(name = "rezervation_location_id")
    private Long locationId;


    public ReservationInfo() {
    }

    public ReservationInfo(Long userId, Long locationId) {
        this.userId = userId;
        this.locationId = locationId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
