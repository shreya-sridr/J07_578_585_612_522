package com.banking.bank.services;

import com.banking.bank.entities.Bank;
import com.banking.bank.repositories.BankRepository;
import com.banking.bank.repositories.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private BranchRepository branchRepository;
    
    public Bank createBank(Bank bank) {
        return bankRepository.save(bank);
    }

    public Optional<Bank> getBank(Long id) {
        return bankRepository.findById(id);
    }

    public List<Bank> getAllBanks() {
        List<Bank> banks = bankRepository.findAll();
        banks.forEach(bank -> {
            bank.setBranches(branchRepository.findByBankId(bank.getId()));
        });
        return banks;
    }
    
}
