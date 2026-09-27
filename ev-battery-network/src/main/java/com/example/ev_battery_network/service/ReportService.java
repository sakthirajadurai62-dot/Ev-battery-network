package com.example.ev_battery_network.service;

import com.example.ev_battery_network.entity.Battery;
import com.example.ev_battery_network.entity.FleetVehicle;
import com.example.ev_battery_network.entity.Finance;
import com.example.ev_battery_network.entity.Invoice;
import com.example.ev_battery_network.entity.Recycling;
import com.example.ev_battery_network.entity.BatterySwap;

import com.example.ev_battery_network.repository.BatteryRepository;
import com.example.ev_battery_network.repository.FleetVehicleRepository;
import com.example.ev_battery_network.repository.FinanceRepository;
import com.example.ev_battery_network.repository.InvoiceRepository;
import com.example.ev_battery_network.repository.RecyclingRepository;
import com.example.ev_battery_network.repository.BatterySwapRepository;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ReportService {

    private final BatteryRepository batteryRepository;
    private final FleetVehicleRepository fleetVehicleRepository;
    private final FinanceRepository financeRepository;
    private final InvoiceRepository invoiceRepository;
    private final RecyclingRepository recyclingRepository;
    private final BatterySwapRepository batterySwapRepository;

    public ReportService(
            BatteryRepository batteryRepository,
            FleetVehicleRepository fleetVehicleRepository,
            FinanceRepository financeRepository,
            InvoiceRepository invoiceRepository,
            RecyclingRepository recyclingRepository,
            BatterySwapRepository batterySwapRepository) {

        this.batteryRepository = batteryRepository;
        this.fleetVehicleRepository = fleetVehicleRepository;
        this.financeRepository = financeRepository;
        this.invoiceRepository = invoiceRepository;
        this.recyclingRepository = recyclingRepository;
        this.batterySwapRepository = batterySwapRepository;
    }

    public long getTotalBatteries() {
        return batteryRepository.count();
    }

    public long getRecyclingBatteries() {
        return batteryRepository.findAll()
                .stream()
                .filter(battery ->
                        battery.getStatus() != null &&
                                battery.getStatus().name().equals("RECYCLING"))
                .count();
    }

    public long getTotalFleetVehicles() {
        return fleetVehicleRepository.count();
    }

    public long getTotalSwaps() {
        return batterySwapRepository.count();
    }

    public long getTotalInvoices() {
        return invoiceRepository.count();
    }

    public BigDecimal getTotalInvoiceAmount() {
        return invoiceRepository.findAll()
                .stream()
                .map(Invoice::getAmount)
                .filter(amount -> amount != null)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getTotalRevenue() {
        return financeRepository.findByTransactionType("REVENUE")
                .stream()
                .map(Finance::getAmount)
                .filter(amount -> amount != null)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getTotalExpenses() {
        return financeRepository.findByTransactionType("EXPENSE")
                .stream()
                .map(Finance::getAmount)
                .filter(amount -> amount != null)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getNetAmount() {
        return getTotalRevenue().subtract(getTotalExpenses());
    }

    public BigDecimal getTotalRecyclingCost() {
        return recyclingRepository.findAll()
                .stream()
                .map(Recycling::getRecyclingCost)
                .filter(cost -> cost != null)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<Battery> getAllBatteries() {
        return batteryRepository.findAll();
    }

    public List<Recycling> getAllRecyclingRecords() {
        return recyclingRepository.findAll();
    }
}