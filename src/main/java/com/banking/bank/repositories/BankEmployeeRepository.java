package com.banking.bank.repositories;

import com.banking.bank.entities.BankEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BankEmployeeRepository extends JpaRepository<BankEmployee, Long> {
    List<BankEmployee> findByBranchId(Long branchId);
}
