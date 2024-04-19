package com.Proje.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "LocationInfo")
public class LocationInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "location_id")
    private long id;
    @Column(name = "location_title")
    private String title;
    @Column(name = "location_adress")
    private String address;
    @Column(name = "location_telephone")
    private String telephone;

    public LocationInfo() {
    }

    public LocationInfo(long id, String title, String address, String telephone) {
        this.id = id;
        this.title = title;
        this.address = address;
        this.telephone = telephone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
