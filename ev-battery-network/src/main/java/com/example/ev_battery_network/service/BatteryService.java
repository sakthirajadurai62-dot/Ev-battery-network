package com.example.ev_battery_network.service;

import com.example.ev_battery_network.entity.Battery;
import com.example.ev_battery_network.entity.BatteryStatus;
import com.example.ev_battery_network.repository.BatteryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatteryService {

    private final BatteryRepository batteryRepository;

    public BatteryService(BatteryRepository batteryRepository) {
        this.batteryRepository = batteryRepository;
    }

    public Battery createBattery(Battery battery) {

        // SoH below 70% → automatically send to recycling
        if (battery.getSohPercentage() != null
                && battery.getSohPercentage().doubleValue() < 70) {

            battery.setStatus(BatteryStatus.RECYCLING);
        }

        return batteryRepository.save(battery);
    }

    public List<Battery> getAllBatteries() {
        return batteryRepository.findAll();
    }

    public Battery getBatteryById(Long id) {
        return batteryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Battery not found"));
    }
}