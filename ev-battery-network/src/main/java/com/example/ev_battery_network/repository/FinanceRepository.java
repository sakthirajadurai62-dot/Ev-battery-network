package com.example.ev_battery_network.repository;

import com.example.ev_battery_network.entity.Finance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FinanceRepository extends JpaRepository<Finance, Long> {

    List<Finance> findByTransactionType(String transactionType);

    List<Finance> findByStatus(String status);
}