package com.example.ev_battery_network.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "recycling_records")
public class Recycling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String batteryCode;

    private String recyclingSpecialist;

    private BigDecimal batterySoh;

    private BigDecimal recyclingCost;

    private String status;

    private LocalDateTime recyclingDate;

    private String remarks;

    @PrePersist
    protected void onCreate() {
        recyclingDate = LocalDateTime.now();

        if (status == null || status.isBlank()) {
            status = "PENDING";
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBatteryCode() {
        return batteryCode;
    }

    public void setBatteryCode(String batteryCode) {
        this.batteryCode = batteryCode;
    }

    public String getRecyclingSpecialist() {
        return recyclingSpecialist;
    }

    public void setRecyclingSpecialist(String recyclingSpecialist) {
        this.recyclingSpecialist = recyclingSpecialist;
    }

    public BigDecimal getBatterySoh() {
        return batterySoh;
    }

    public void setBatterySoh(BigDecimal batterySoh) {
        this.batterySoh = batterySoh;
    }

    public BigDecimal getRecyclingCost() {
        return recyclingCost;
    }

    public void setRecyclingCost(BigDecimal recyclingCost) {
        this.recyclingCost = recyclingCost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getRecyclingDate() {
        return recyclingDate;
    }

    public void setRecyclingDate(LocalDateTime recyclingDate) {
        this.recyclingDate = recyclingDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}