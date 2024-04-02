package com.Proje.demo.services;
import com.Proje.demo.entity.LocationInfo;
import java.util.List;
import java.util.Optional;

public interface LocationService {
    List<LocationInfo> findAllLocation();
    Optional<LocationInfo> findById(long id);
    LocationInfo saveLocation(LocationInfo locationInfo);
    LocationInfo updateLocation(LocationInfo locationInfo);

    void deleteLocation(Long id);
}
