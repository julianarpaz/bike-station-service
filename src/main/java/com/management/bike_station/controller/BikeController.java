package com.management.bike_station.controller;

import com.management.bike_station.entity.Bike;
import com.management.bike_station.repository.BikeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/bikes")
public class BikeController {

    private BikeRepository repository;

    @GetMapping
    public ResponseEntity<List<Bike>> getBikes(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bike> getBike(@PathVariable UUID id){
        return repository.findById(id).map(ResponseEntity:: ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Bike> addBike(@RequestBody Bike bike){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(bike));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bike> updateBike(@RequestBody Bike bike){
        return repository.findById(bike.getId()).map(response-> ResponseEntity.status(HttpStatus.OK).body(repository.save(bike))).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }


}
