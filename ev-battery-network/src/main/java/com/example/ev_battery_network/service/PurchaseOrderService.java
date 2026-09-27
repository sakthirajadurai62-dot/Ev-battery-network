package com.example.ev_battery_network.service;

import com.example.ev_battery_network.entity.PurchaseOrder;
import com.example.ev_battery_network.repository.PurchaseOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseOrderService {

    private final PurchaseOrderRepository purchaseOrderRepository;

    public PurchaseOrderService(
            PurchaseOrderRepository purchaseOrderRepository) {

        this.purchaseOrderRepository = purchaseOrderRepository;
    }

    public PurchaseOrder createPurchaseOrder(PurchaseOrder purchaseOrder) {

        return purchaseOrderRepository.save(purchaseOrder);
    }

    public List<PurchaseOrder> getAllPurchaseOrders() {

        return purchaseOrderRepository.findAll();
    }

    public PurchaseOrder getPurchaseOrderById(Long id) {

        return purchaseOrderRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Purchase order not found with ID: " + id
                        )
                );
    }

    public PurchaseOrder getPurchaseOrderByNumber(String poNumber) {

        return purchaseOrderRepository.findByPoNumber(poNumber)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Purchase order not found: " + poNumber
                        )
                );
    }

    public List<PurchaseOrder> getPurchaseOrdersByStatus(
            String status) {

        return purchaseOrderRepository.findByStatus(status);
    }

    public PurchaseOrder updatePurchaseOrder(
            Long id,
            PurchaseOrder updatedOrder) {

        PurchaseOrder existingOrder =
                getPurchaseOrderById(id);

        existingOrder.setPoNumber(
                updatedOrder.getPoNumber()
        );

        existingOrder.setVendorName(
                updatedOrder.getVendorName()
        );

        existingOrder.setProductName(
                updatedOrder.getProductName()
        );

        existingOrder.setQuantity(
                updatedOrder.getQuantity()
        );

        existingOrder.setUnitPrice(
                updatedOrder.getUnitPrice()
        );

        existingOrder.setStatus(
                updatedOrder.getStatus()
        );

        return purchaseOrderRepository.save(existingOrder);
    }

    public PurchaseOrder updateStatus(
            Long id,
            String status) {

        PurchaseOrder existingOrder =
                getPurchaseOrderById(id);

        existingOrder.setStatus(status);

        return purchaseOrderRepository.save(existingOrder);
    }

    public void deletePurchaseOrder(Long id) {

        if (!purchaseOrderRepository.existsById(id)) {

            throw new RuntimeException(
                    "Purchase order not found with ID: " + id
            );
        }

        purchaseOrderRepository.deleteById(id);
    }
}