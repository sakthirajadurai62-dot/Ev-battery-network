package com.example.ev_battery_network.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/")
    public String dashboard() {
        return "dashboard";
    }

    @GetMapping("/batteries")
    public String batteries() {
        return "batteries";
    }

    @GetMapping("/swaps")
    public String swaps() {
        return "swaps";
    }

    @GetMapping("/fleet")
    public String fleet() {
        return "fleet";
    }

    @GetMapping("/invoices")
    public String invoices() {
        return "invoices";
    }

    @GetMapping("/recycling")
    public String recycling() {
        return "recycling";
    }

    @GetMapping("/finance")
    public String finance() {
        return "finance";
    }

    @GetMapping("/reports")
    public String reports() {
        return "reports";
    }
    @GetMapping("/purchase-orders")
    public String purchaseOrders() {
        return "purchase-orders";
    }
}