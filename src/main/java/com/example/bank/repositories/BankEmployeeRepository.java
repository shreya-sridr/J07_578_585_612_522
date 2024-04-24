package com.banking.bank.repositories;

import com.banking.bank.entities.BankEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankEmployeeRepository extends JpaRepository<BankEmployee, Long> {
}
