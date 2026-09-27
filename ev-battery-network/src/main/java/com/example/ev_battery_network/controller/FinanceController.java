package com.example.ev_battery_network.controller;

import com.example.ev_battery_network.entity.Finance;
import com.example.ev_battery_network.service.FinanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/finance")
public class FinanceController {

    private final FinanceService financeService;

    public FinanceController(FinanceService financeService) {
        this.financeService = financeService;
    }

    @PostMapping
    public ResponseEntity<Finance> createFinance(
            @RequestBody Finance finance) {

        return ResponseEntity.ok(
                financeService.createFinance(finance)
        );
    }

    @GetMapping
    public ResponseEntity<List<Finance>> getAllFinanceRecords() {

        return ResponseEntity.ok(
                financeService.getAllFinanceRecords()
        );
    }

    @GetMapping("/revenue")
    public ResponseEntity<List<Finance>> getRevenueRecords() {

        return ResponseEntity.ok(
                financeService.getRevenueRecords()
        );
    }

    @GetMapping("/expense")
    public ResponseEntity<List<Finance>> getExpenseRecords() {

        return ResponseEntity.ok(
                financeService.getExpenseRecords()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Finance> getFinanceById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                financeService.getFinanceById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Finance> updateFinance(
            @PathVariable Long id,
            @RequestBody Finance finance) {

        return ResponseEntity.ok(
                financeService.updateFinance(id, finance)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFinance(
            @PathVariable Long id) {

        financeService.deleteFinance(id);

        return ResponseEntity.ok(
                "Finance record deleted successfully"
        );
    }
}