package com.example.ev_battery_network.service;

import com.example.ev_battery_network.entity.BatterySwap;
import com.example.ev_battery_network.repository.BatterySwapRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatterySwapService {

    private final BatterySwapRepository batterySwapRepository;

    public BatterySwapService(BatterySwapRepository batterySwapRepository) {
        this.batterySwapRepository = batterySwapRepository;
    }

    public BatterySwap createSwap(BatterySwap swap) {
        return batterySwapRepository.save(swap);
    }

    public List<BatterySwap> getAllSwaps() {
        return batterySwapRepository.findAll();
    }
}