package com.banking.bank.controllers;
import java.util.List;
import com.banking.bank.entities.BankEmployee;
import com.banking.bank.services.BankEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/employees")
public class BankEmployeeController {

    @Autowired
    private BankEmployeeService employeeService;

    @PostMapping("/{branchId}")
    public BankEmployee createEmployee(@RequestBody BankEmployee employee, @PathVariable Long branchId) {
        return employeeService.createEmployee(employee, branchId);
    }

    @GetMapping("/{id}")
    public BankEmployee getEmployee(@PathVariable Long id) {
        return employeeService.getEmployee(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

    @GetMapping("/{branchId}")
    public List<BankEmployee> getEmployeesByBranchId(@PathVariable Long branchId) {
        return employeeService.getEmployeesByBranchId(branchId);
    }
}
