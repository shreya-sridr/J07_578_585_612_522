package com.banking.bank.services;

import com.banking.bank.entities.ATMOperator;
import com.banking.bank.repositories.ATMOperatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ATMOperatorService {

    @Autowired
    private ATMOperatorRepository atmOperatorRepository;

    public ATMOperator createATMOperator(ATMOperator atmOperator) {
        return atmOperatorRepository.save(atmOperator);
    }

    public Optional<ATMOperator> getATMOperator(Long id) {
        return atmOperatorRepository.findById(id);
    }

    public ATMOperator deposit(Long id, double amount) {
        ATMOperator atmOperator = getATMOperator(id).orElseThrow(() -> new RuntimeException("ATM Operator not found"));
        atmOperator.setDeposit(atmOperator.getDeposit() + amount);
        return atmOperatorRepository.save(atmOperator);
    }

    public ATMOperator performMaintenanceRecord(Long id) {
        ATMOperator atmOperator = getATMOperator(id).orElseThrow(() -> new RuntimeException("ATM Operator not found"));
        atmOperator.setMaintenanceRecord(true);
        return atmOperatorRepository.save(atmOperator);
    }

    public ATMOperator checkMachine(Long id) {
        ATMOperator atmOperator = getATMOperator(id).orElseThrow(() -> new RuntimeException("ATM Operator not found"));
        atmOperator.setCheckMachine(true);
        return atmOperatorRepository.save(atmOperator);
    }

    public ATMOperator performServiceCheck(Long id) {
        ATMOperator atmOperator = getATMOperator(id).orElseThrow(() -> new RuntimeException("ATM Operator not found"));
        atmOperator.setServiceCheck(true);
        return atmOperatorRepository.save(atmOperator);
    }

    public ATMOperator performDiagnosticCheck(Long id) {
        ATMOperator atmOperator = getATMOperator(id).orElseThrow(() -> new RuntimeException("ATM Operator not found"));
        atmOperator.setDiagnosticCheck(true);
        return atmOperatorRepository.save(atmOperator);
    }
}