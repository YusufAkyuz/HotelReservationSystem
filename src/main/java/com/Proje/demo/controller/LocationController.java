package com.Proje.demo.controller;

import com.Proje.demo.entity.LocationInfo;
import com.Proje.demo.services.LocationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/location")
public class LocationController {
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }
    @GetMapping
    public List<LocationInfo> findAllLocation() {
        return locationService.findAllLocation();
    }

    @GetMapping("/{id}")
    public Optional<LocationInfo> findLocationById(@PathVariable("id") Long id) {
        return locationService.findById(id);
    }

    @PostMapping
    public LocationInfo saveLocation(@RequestBody LocationInfo locationInfo) {
        return locationService.saveLocation(locationInfo);
    }

    @PutMapping
    public LocationInfo updateLocation(@RequestBody LocationInfo locationInfo) {
        return locationService.updateLocation(locationInfo);
    }

    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable("id") long id) {
        locationService.deleteLocation(id);
    }
}
