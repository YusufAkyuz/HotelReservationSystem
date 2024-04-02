package com.Proje.demo.services.impl;

import com.Proje.demo.entity.LocationInfo;
import com.Proje.demo.repository.LocationRepository;
import com.Proje.demo.services.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<LocationInfo> findAllLocation() {
        return locationRepository.findAll();
    }

    @Override
    public Optional<LocationInfo> findById(long id) {
        return locationRepository.findById(id);
    }

    @Override
    public LocationInfo saveLocation(LocationInfo locationInfo) {
        return locationRepository.save(locationInfo);
    }

    @Override
    public LocationInfo updateLocation(LocationInfo locationInfo) {
        return locationRepository.save(locationInfo);
    }

    @Override
    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }
}
