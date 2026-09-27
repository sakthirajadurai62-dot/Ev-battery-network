package com.example.ev_battery_network.controller;

import com.example.ev_battery_network.entity.PurchaseOrder;
import com.example.ev_battery_network.service.PurchaseOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchase-orders")
public class PurchaseOrderController {

    private final PurchaseOrderService purchaseOrderService;

    public PurchaseOrderController(
            PurchaseOrderService purchaseOrderService) {

        this.purchaseOrderService = purchaseOrderService;
    }

    @PostMapping
    public ResponseEntity<PurchaseOrder> createPurchaseOrder(
            @RequestBody PurchaseOrder purchaseOrder) {

        return ResponseEntity.ok(
                purchaseOrderService.createPurchaseOrder(purchaseOrder)
        );
    }

    @GetMapping
    public ResponseEntity<List<PurchaseOrder>> getAllPurchaseOrders() {

        return ResponseEntity.ok(
                purchaseOrderService.getAllPurchaseOrders()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseOrder> getPurchaseOrderById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                purchaseOrderService.getPurchaseOrderById(id)
        );
    }

    @GetMapping("/number/{poNumber}")
    public ResponseEntity<PurchaseOrder> getPurchaseOrderByNumber(
            @PathVariable String poNumber) {

        return ResponseEntity.ok(
                purchaseOrderService.getPurchaseOrderByNumber(poNumber)
        );
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<PurchaseOrder>> getByStatus(
            @PathVariable String status) {

        return ResponseEntity.ok(
                purchaseOrderService.getPurchaseOrdersByStatus(status)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<PurchaseOrder> updatePurchaseOrder(
            @PathVariable Long id,
            @RequestBody PurchaseOrder purchaseOrder) {

        return ResponseEntity.ok(
                purchaseOrderService.updatePurchaseOrder(
                        id,
                        purchaseOrder
                )
        );
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<PurchaseOrder> updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        return ResponseEntity.ok(
                purchaseOrderService.updateStatus(
                        id,
                        status
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePurchaseOrder(
            @PathVariable Long id) {

        purchaseOrderService.deletePurchaseOrder(id);

        return ResponseEntity.ok(
                "Purchase order deleted successfully"
        );
    }
}