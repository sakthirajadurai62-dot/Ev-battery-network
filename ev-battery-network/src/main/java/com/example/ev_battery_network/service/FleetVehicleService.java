package com.example.ev_battery_network.service;

import com.example.ev_battery_network.entity.FleetVehicle;
import com.example.ev_battery_network.repository.FleetVehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FleetVehicleService {

    private final FleetVehicleRepository fleetVehicleRepository;

    public FleetVehicleService(
            FleetVehicleRepository fleetVehicleRepository) {
        this.fleetVehicleRepository = fleetVehicleRepository;
    }

    public FleetVehicle createVehicle(FleetVehicle vehicle) {
        return fleetVehicleRepository.save(vehicle);
    }

    public List<FleetVehicle> getAllVehicles() {
        return fleetVehicleRepository.findAll();
    }

    public FleetVehicle getVehicleById(Long id) {
        return fleetVehicleRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Fleet vehicle not found"));
    }

    public FleetVehicle updateVehicle(
            Long id,
            FleetVehicle updatedVehicle) {

        FleetVehicle existing =
                getVehicleById(id);

        existing.setVehicleNumber(
                updatedVehicle.getVehicleNumber());

        existing.setDriverName(
                updatedVehicle.getDriverName());

        existing.setFleetCompany(
                updatedVehicle.getFleetCompany());

        existing.setContactNumber(
                updatedVehicle.getContactNumber());

        existing.setCurrentBatteryCode(
                updatedVehicle.getCurrentBatteryCode());

        existing.setBatterySoh(
                updatedVehicle.getBatterySoh());

        existing.setVehicleStatus(
                updatedVehicle.getVehicleStatus());

        return fleetVehicleRepository.save(existing);
    }

    public void deleteVehicle(Long id) {
        fleetVehicleRepository.deleteById(id);
    }
}