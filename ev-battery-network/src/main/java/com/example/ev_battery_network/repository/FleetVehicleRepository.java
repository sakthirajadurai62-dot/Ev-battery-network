package com.example.ev_battery_network.repository;

import com.example.ev_battery_network.entity.FleetVehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FleetVehicleRepository
        extends JpaRepository<FleetVehicle, Long> {

    Optional<FleetVehicle> findByVehicleNumber(String vehicleNumber);
}