package com.banking.bank.services;

import com.banking.bank.entities.BankEmployee;
import com.banking.bank.entities.Branch;
import com.banking.bank.repositories.BankEmployeeRepository;
import com.banking.bank.repositories.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankEmployeeService {

    @Autowired
    private BankEmployeeRepository employeeRepository;

    @Autowired
    private BranchRepository branchRepository;

    public BankEmployee createEmployee(BankEmployee employee, Long branchId) {
        Branch branch = branchRepository.findById(branchId)
            .orElseThrow(() -> new RuntimeException("Branch not found"));
        employee.setBranch(branch);
        return employeeRepository.save(employee);
    }

    public Optional<BankEmployee> getEmployee(Long id) {
        return employeeRepository.findById(id);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
