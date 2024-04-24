package com.banking.bank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.banking.bank.repositories.AccountRepository;

import com.banking.bank.entities.Account;
import com.banking.bank.entities.SavingsAccount;
import com.banking.bank.entities.CurrentAccount;
import com.banking.bank.entities.LoanAccount;
import com.banking.bank.services.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Optional;

import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;
    
    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/{id}")
    public Account getAccount(@PathVariable Long id) {
        return accountService.getAccount(id).orElseThrow(() -> new RuntimeException("Account not found"));
    }

    // Get details
    @GetMapping("/{username}/details")
    public Account getAccountDetails(@PathVariable String username) {
        return accountService.getAccountDetails(username);
    }

    // Deposit
    @PostMapping("/{username}/deposit")
    public Account deposit(@PathVariable String username, @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        return accountService.deposit(username, amount);
    }

    // Withdraw
    @PostMapping("/{username}/withdraw")
    public Account withdraw(@PathVariable String username, @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        return accountService.withdraw(username, amount);
    }

    // Check Balance
    @GetMapping("/{username}/balance")
    public double checkBalance(@PathVariable String username) {
        return accountService.checkBalance(username);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");
        boolean isValid = accountService.validateLogin(username, password);
        if (isValid) {
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

}
