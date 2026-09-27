package com.example.ev_battery_network.controller;

import com.example.ev_battery_network.entity.Recycling;
import com.example.ev_battery_network.service.RecyclingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recycling")
public class RecyclingController {

    private final RecyclingService recyclingService;

    public RecyclingController(RecyclingService recyclingService) {
        this.recyclingService = recyclingService;
    }

    @PostMapping
    public ResponseEntity<Recycling> createRecycling(
            @RequestBody Recycling recycling) {

        return ResponseEntity.ok(
                recyclingService.createRecycling(recycling)
        );
    }

    @GetMapping
    public ResponseEntity<List<Recycling>> getAllRecycling() {

        return ResponseEntity.ok(
                recyclingService.getAllRecyclingRecords()
        );
    }

    @GetMapping("/pending")
    public ResponseEntity<List<Recycling>> getPendingRecycling() {

        return ResponseEntity.ok(
                recyclingService.getPendingRecycling()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recycling> getRecyclingById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                recyclingService.getRecyclingById(id)
        );
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Recycling> updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        return ResponseEntity.ok(
                recyclingService.updateStatus(id, status)
        );
    }
}