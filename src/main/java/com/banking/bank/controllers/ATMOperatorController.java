package com.banking.bank.controllers;

import com.banking.bank.entities.ATMOperator;
import com.banking.bank.services.ATMOperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/atm-operators")
public class ATMOperatorController {

    @Autowired
    private ATMOperatorService atmOperatorService;

    // Create ATM Operator
    @PostMapping
    public ATMOperator createATMOperator(@RequestBody ATMOperator atmOperator) {
        return atmOperatorService.createATMOperator(atmOperator);
    }

    // Get ATM Operator by ID
    @GetMapping("/{id}")
    public ATMOperator getATMOperator(@PathVariable Long id) {
        return atmOperatorService.getATMOperator(id)
                .orElseThrow(() -> new RuntimeException("ATM Operator not found"));
    }

    // Perform Deposit
    @PostMapping("/{id}/deposit")
    public ATMOperator deposit(@PathVariable Long id, @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        return atmOperatorService.deposit(id, amount);
    }

    // Perform Maintenance Record
    @PostMapping("/{id}/maintenance-record")
    public ATMOperator performMaintenanceRecord(@PathVariable Long id) {
        return atmOperatorService.performMaintenanceRecord(id);
    }

    // Check Machine
    @PostMapping("/{id}/check-machine")
    public ATMOperator checkMachine(@PathVariable Long id) {
        return atmOperatorService.checkMachine(id);
    }

    // Perform Service Check
    @PostMapping("/{id}/service-check")
    public ATMOperator performServiceCheck(@PathVariable Long id) {
        return atmOperatorService.performServiceCheck(id);
    }

    // Perform Diagnostic Check
    @PostMapping("/{id}/diagnostic-check")
    public ATMOperator performDiagnosticCheck(@PathVariable Long id) {
        return atmOperatorService.performDiagnosticCheck(id);
    }
}