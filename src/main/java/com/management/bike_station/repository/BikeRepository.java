package com.management.bike_station.repository;

import com.management.bike_station.entity.Bike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BikeRepository extends JpaRepository<Bike, UUID>  {
    List<Bike> findByStationIdAndStatus(UUID stationId, String status);
}
