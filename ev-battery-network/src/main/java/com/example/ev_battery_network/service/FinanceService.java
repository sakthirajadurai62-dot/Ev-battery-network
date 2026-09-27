package com.example.ev_battery_network.service;

import com.example.ev_battery_network.entity.Finance;
import com.example.ev_battery_network.repository.FinanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinanceService {

    private final FinanceRepository financeRepository;

    public FinanceService(FinanceRepository financeRepository) {
        this.financeRepository = financeRepository;
    }

    public Finance createFinance(Finance finance) {
        return financeRepository.save(finance);
    }

    public List<Finance> getAllFinanceRecords() {
        return financeRepository.findAll();
    }

    public List<Finance> getRevenueRecords() {
        return financeRepository.findByTransactionType("REVENUE");
    }

    public List<Finance> getExpenseRecords() {
        return financeRepository.findByTransactionType("EXPENSE");
    }

    public Finance getFinanceById(Long id) {
        return financeRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Finance record not found"));
    }

    public Finance updateFinance(Long id, Finance updatedFinance) {

        Finance existingFinance = getFinanceById(id);

        existingFinance.setTransactionType(
                updatedFinance.getTransactionType());

        existingFinance.setDescription(
                updatedFinance.getDescription());

        existingFinance.setAmount(
                updatedFinance.getAmount());

        existingFinance.setPaymentMethod(
                updatedFinance.getPaymentMethod());

        existingFinance.setStatus(
                updatedFinance.getStatus());

        return financeRepository.save(existingFinance);
    }

    public void deleteFinance(Long id) {

        if (!financeRepository.existsById(id)) {
            throw new RuntimeException(
                    "Finance record not found");
        }

        financeRepository.deleteById(id);
    }
}