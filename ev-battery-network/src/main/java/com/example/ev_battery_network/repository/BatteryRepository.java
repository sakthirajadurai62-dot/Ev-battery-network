package com.example.ev_battery_network.repository;

import com.example.ev_battery_network.entity.Battery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BatteryRepository extends JpaRepository<Battery, Long> {

    Optional<Battery> findByBatteryCode(String batteryCode);
}