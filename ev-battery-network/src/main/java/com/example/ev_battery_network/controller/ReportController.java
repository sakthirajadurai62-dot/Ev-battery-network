package com.example.ev_battery_network.controller;

import com.example.ev_battery_network.entity.Battery;
import com.example.ev_battery_network.entity.Recycling;
import com.example.ev_battery_network.service.ReportService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/summary")
    public ResponseEntity<Map<String, Object>> getSummary() {

        Map<String, Object> report = new HashMap<>();

        report.put("totalBatteries", reportService.getTotalBatteries());
        report.put("recyclingBatteries", reportService.getRecyclingBatteries());
        report.put("totalFleetVehicles", reportService.getTotalFleetVehicles());
        report.put("totalSwaps", reportService.getTotalSwaps());
        report.put("totalInvoices", reportService.getTotalInvoices());

        report.put("totalInvoiceAmount",
                reportService.getTotalInvoiceAmount());

        report.put("totalRevenue",
                reportService.getTotalRevenue());

        report.put("totalExpenses",
                reportService.getTotalExpenses());

        report.put("netAmount",
                reportService.getNetAmount());

        report.put("totalRecyclingCost",
                reportService.getTotalRecyclingCost());

        return ResponseEntity.ok(report);
    }

    @GetMapping("/batteries")
    public ResponseEntity<List<Battery>> getBatteryReport() {
        return ResponseEntity.ok(
                reportService.getAllBatteries()
        );
    }

    @GetMapping("/recycling")
    public ResponseEntity<List<Recycling>> getRecyclingReport() {
        return ResponseEntity.ok(
                reportService.getAllRecyclingRecords()
        );
    }
}