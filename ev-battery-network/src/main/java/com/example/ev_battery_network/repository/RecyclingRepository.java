package com.example.ev_battery_network.repository;

import com.example.ev_battery_network.entity.Recycling;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecyclingRepository extends JpaRepository<Recycling, Long> {

    List<Recycling> findByStatus(String status);
}