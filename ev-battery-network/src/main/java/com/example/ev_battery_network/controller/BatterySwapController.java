package com.example.ev_battery_network.controller;

import com.example.ev_battery_network.entity.BatterySwap;
import com.example.ev_battery_network.service.BatterySwapService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/swaps")
public class BatterySwapController {

    private final BatterySwapService batterySwapService;

    public BatterySwapController(BatterySwapService batterySwapService) {
        this.batterySwapService = batterySwapService;
    }

    @PostMapping
    public ResponseEntity<BatterySwap> createSwap(
            @RequestBody BatterySwap swap) {

        return ResponseEntity.ok(
                batterySwapService.createSwap(swap)
        );
    }

    @GetMapping
    public ResponseEntity<List<BatterySwap>> getAllSwaps() {

        return ResponseEntity.ok(
                batterySwapService.getAllSwaps()
        );
    }
}