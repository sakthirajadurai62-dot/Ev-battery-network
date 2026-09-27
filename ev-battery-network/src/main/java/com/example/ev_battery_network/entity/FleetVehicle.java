package com.example.ev_battery_network.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "fleet_vehicles")
public class FleetVehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String vehicleNumber;

    private String driverName;

    private String fleetCompany;

    private String contactNumber;

    private String currentBatteryCode;

    private Double batterySoh;

    private String vehicleStatus;

    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {

        createdAt = LocalDateTime.now();

        if (vehicleStatus == null || vehicleStatus.isBlank()) {
            vehicleStatus = "ACTIVE";
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getFleetCompany() {
        return fleetCompany;
    }

    public void setFleetCompany(String fleetCompany) {
        this.fleetCompany = fleetCompany;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getCurrentBatteryCode() {
        return currentBatteryCode;
    }

    public void setCurrentBatteryCode(String currentBatteryCode) {
        this.currentBatteryCode = currentBatteryCode;
    }

    public Double getBatterySoh() {
        return batterySoh;
    }

    public void setBatterySoh(Double batterySoh) {
        this.batterySoh = batterySoh;
    }

    public String getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(String vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}