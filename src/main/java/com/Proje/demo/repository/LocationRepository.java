package com.Proje.demo.repository;

import com.Proje.demo.entity.LocationInfo;
import org.springframework.data.jpa.repository.JpaRepository;
// backend yazarken bir repository oluşturmak, kodu organize etmenin, yeniden kullanılabilir hale getirmenin,
// geçmişini takip etmenin ve dağıtmanın etkili bir yoludur.

public interface LocationRepository extends JpaRepository<LocationInfo, Long> {
}
