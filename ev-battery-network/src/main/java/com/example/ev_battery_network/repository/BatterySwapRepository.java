package com.example.ev_battery_network.repository;

import com.example.ev_battery_network.entity.BatterySwap;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatterySwapRepository
        extends JpaRepository<BatterySwap, Long> {
}