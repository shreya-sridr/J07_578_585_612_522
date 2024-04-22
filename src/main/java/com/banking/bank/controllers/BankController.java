package com.banking.bank.controllers;

import com.banking.bank.entities.Bank;
import com.banking.bank.services.BankService;
import com.banking.bank.repositories.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/banks")
public class BankController {

    @Autowired
    private BankService bankService;

    @Autowired
    private BranchRepository branchRepository;


    @PostMapping
    public Bank createBank(@RequestBody Bank bank) {
        return bankService.createBank(bank);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Bank> getBank(@PathVariable Long id) {
        Bank bank = bankService.getBank(id).orElseThrow(() -> new RuntimeException("Bank not found"));
        bank.setBranches(branchRepository.findByBankId(id));
        return ResponseEntity.ok().body(bank);
    }


    @GetMapping
    public List<Bank> getAllBanks() {
        return bankService.getAllBanks();
    }
}
