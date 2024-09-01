package com.management.bike_station.service;

import com.management.bike_station.entity.Bike;
import com.management.bike_station.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StationService {

    @Autowired
    private final BikeRepository bikeRepository;

    @Autowired
    public StationService(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    public List<Bike> getAvailableBikesInStation(UUID stationId) {
        return bikeRepository.findByStationIdAndStatus(stationId, "available");
    }
}

