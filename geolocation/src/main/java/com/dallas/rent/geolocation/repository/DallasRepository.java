package com.dallas.rent.geolocation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.dallas.rent.geolocation.model.Dallas;

@Repository
public interface DallasRepository extends JpaRepository<Dallas, Long> {

    @Query(value = "SELECT * from dallas_rent where ST_DistanceSphere(geom, ST_MakePoint(:lon, :lat)) <= :distanceM", nativeQuery = true)
    List<Dallas> findNearWithinDistance(@Param("lon") Double lon, @Param("lat") Double lat,
            @Param("distanceM") double distanceM);
}
