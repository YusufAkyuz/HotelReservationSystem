package com.Proje.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "reservation")
public class AdminReservationInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userId")
    private Long userId;
    @Column(name = "location_id")
    private Long locationId;

    public AdminReservationInfo() {

    }

    public AdminReservationInfo(Long userId, Long locationId) {
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
}
