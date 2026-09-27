package com.example.ev_battery_network.service;

import com.example.ev_battery_network.entity.Recycling;
import com.example.ev_battery_network.repository.RecyclingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecyclingService {

    private final RecyclingRepository recyclingRepository;

    public RecyclingService(RecyclingRepository recyclingRepository) {
        this.recyclingRepository = recyclingRepository;
    }

    public Recycling createRecycling(Recycling recycling) {
        return recyclingRepository.save(recycling);
    }

    public List<Recycling> getAllRecyclingRecords() {
        return recyclingRepository.findAll();
    }

    public List<Recycling> getPendingRecycling() {
        return recyclingRepository.findByStatus("PENDING");
    }

    public Recycling getRecyclingById(Long id) {
        return recyclingRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Recycling record not found"));
    }

    public Recycling updateStatus(Long id, String status) {
        Recycling recycling = getRecyclingById(id);
        recycling.setStatus(status);
        return recyclingRepository.save(recycling);
    }
}