package com.example.ev_battery_network.controller;

import com.example.ev_battery_network.entity.FleetVehicle;
import com.example.ev_battery_network.service.FleetVehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fleet")
public class FleetVehicleController {

    private final FleetVehicleService fleetVehicleService;

    public FleetVehicleController(
            FleetVehicleService fleetVehicleService) {
        this.fleetVehicleService = fleetVehicleService;
    }

    @PostMapping
    public ResponseEntity<FleetVehicle> createVehicle(
            @RequestBody FleetVehicle vehicle) {

        return ResponseEntity.ok(
                fleetVehicleService.createVehicle(vehicle)
        );
    }

    @GetMapping
    public ResponseEntity<List<FleetVehicle>> getAllVehicles() {

        return ResponseEntity.ok(
                fleetVehicleService.getAllVehicles()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<FleetVehicle> getVehicleById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                fleetVehicleService.getVehicleById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<FleetVehicle> updateVehicle(
            @PathVariable Long id,
            @RequestBody FleetVehicle vehicle) {

        return ResponseEntity.ok(
                fleetVehicleService.updateVehicle(id, vehicle)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVehicle(
            @PathVariable Long id) {

        fleetVehicleService.deleteVehicle(id);

        return ResponseEntity.ok(
                "Fleet vehicle deleted successfully"
        );
    }
}