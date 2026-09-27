package com.example.ev_battery_network.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "battery_swaps")
public class BatterySwap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String vehicleNumber;

    @Column(nullable = false)
    private String driverName;

    @Column(nullable = false)
    private String oldBatteryCode;

    @Column(nullable = false)
    private String newBatteryCode;

    @Column(nullable = false)
    private BigDecimal swapCharge;

    @Column(nullable = false)
    private LocalDateTime swapTime;

    @PrePersist
    public void prePersist() {
        if (swapTime == null) {
            swapTime = LocalDateTime.now();
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

    public String getOldBatteryCode() {
        return oldBatteryCode;
    }

    public void setOldBatteryCode(String oldBatteryCode) {
        this.oldBatteryCode = oldBatteryCode;
    }

    public String getNewBatteryCode() {
        return newBatteryCode;
    }

    public void setNewBatteryCode(String newBatteryCode) {
        this.newBatteryCode = newBatteryCode;
    }

    public BigDecimal getSwapCharge() {
        return swapCharge;
    }

    public void setSwapCharge(BigDecimal swapCharge) {
        this.swapCharge = swapCharge;
    }

    public LocalDateTime getSwapTime() {
        return swapTime;
    }

    public void setSwapTime(LocalDateTime swapTime) {
        this.swapTime = swapTime;
    }
}