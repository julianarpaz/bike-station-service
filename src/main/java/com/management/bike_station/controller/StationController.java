package com.management.bike_station.controller;

import com.management.bike_station.entity.Bike;
import com.management.bike_station.entity.Station;
import com.management.bike_station.repository.StationRepository;
import com.management.bike_station.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/stations")
public class StationController {

    @Autowired
    private StationService stationService;

    @Autowired
    private StationRepository repository;

    @GetMapping("/{id}/bikes")
    public ResponseEntity<List<Bike>> getAvailableBikesInStation(@PathVariable UUID id) {
        List<Bike> availableBikes = stationService.getAvailableBikesInStation(id);
        return ResponseEntity.ok(availableBikes);
    }

    @GetMapping
    public ResponseEntity<List<Station>> getStations(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Station> getStation(@PathVariable UUID id){
        return repository.findById(id).map(ResponseEntity:: ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Station> addStation(@RequestBody Station station){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(station));
    }

}
