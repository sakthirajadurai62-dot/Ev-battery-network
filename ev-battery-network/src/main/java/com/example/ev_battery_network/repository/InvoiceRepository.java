package com.example.ev_battery_network.repository;

import com.example.ev_battery_network.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}