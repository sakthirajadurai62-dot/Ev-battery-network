package com.example.ev_battery_network.controller;

import com.example.ev_battery_network.entity.Battery;
import com.example.ev_battery_network.service.BatteryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/batteries")
public class BatteryController {

    private final BatteryService batteryService;

    public BatteryController(BatteryService batteryService) {
        this.batteryService = batteryService;
    }

    @PostMapping("/packs")
    public ResponseEntity<Battery> createBattery(
            @RequestBody Battery battery) {

        return ResponseEntity.ok(
                batteryService.createBattery(battery)
        );
    }

    @GetMapping
    public ResponseEntity<List<Battery>> getAllBatteries() {

        return ResponseEntity.ok(
                batteryService.getAllBatteries()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Battery> getBatteryById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                batteryService.getBatteryById(id)
        );
    }
}