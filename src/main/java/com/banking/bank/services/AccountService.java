package com.banking.bank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.bank.entities.Account;
import com.banking.bank.entities.SavingsAccount;
import com.banking.bank.entities.CurrentAccount;
import com.banking.bank.entities.LoanAccount;
import com.banking.bank.repositories.AccountRepository;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public SavingsAccount createSavingsAccount(SavingsAccount account) {
        if (accountRepository.existsByUsername(account.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        return accountRepository.save(account);
    }
    
    public CurrentAccount createCurrentAccount(CurrentAccount account) {
        if (accountRepository.existsByUsername(account.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        return accountRepository.save(account);
    }
    
    public LoanAccount createLoanAccount(LoanAccount account) {
        if (accountRepository.existsByUsername(account.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        return accountRepository.save(account);
    }    

    public Optional<Account> getAccount(Long id) {
        return accountRepository.findById(id);
    }

    public Account getAccountDetails(String username) {
        return accountRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }
    
    public Optional<Account> getAccountByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    public double checkBalance(String username) {
        Account account = accountRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        return account.getBalance();
    }
    

    public Account deposit(String username, double amount) {
        Account account = accountRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        account.setBalance(account.getBalance() + amount);
        Account updatedAccount = accountRepository.save(account);
        return updatedAccount;
    }
    

    public Account withdraw(String username, double amount) {
        Account account = accountRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient funds");
        }
        double newBalance = account.getBalance() - amount;
        account.setBalance(newBalance);
        return accountRepository.save(account);
    }

    public boolean validateLogin(String username, String password) {
        Optional<Account> account = accountRepository.findByUsernameAndPassword(username, password);
        return account.isPresent();
    }
}
