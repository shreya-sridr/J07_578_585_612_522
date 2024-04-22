package com.banking.bank.repositories;

import com.banking.bank.entities.ATMOperator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ATMOperatorRepository extends JpaRepository<ATMOperator, Long> {
    // Even though the interface appears empty, it inherits methods like findById, save, delete, etc., from JpaRepository
}