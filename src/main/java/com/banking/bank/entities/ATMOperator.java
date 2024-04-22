package com.banking.bank.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ATMOperator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String inputDeposit;
    private int interval_value;
    private boolean maintenanceRecord;
    private boolean checkMachine;
    private double deposit;
    private boolean serviceCheck;
    private boolean diagnosticCheck;
}