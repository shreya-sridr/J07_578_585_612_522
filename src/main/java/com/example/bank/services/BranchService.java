package com.banking.bank.services;

import com.banking.bank.entities.Branch;
import com.banking.bank.entities.Bank;
import com.banking.bank.repositories.BranchRepository;
import com.banking.bank.repositories.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BranchService {

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private BankRepository bankRepository;

    public Branch createBranch(Branch branch, Long bankId) {
        Bank bank = bankRepository.findById(bankId)
            .orElseThrow(() -> new RuntimeException("Bank not found"));
        branch.setBank(bank);
        return branchRepository.save(branch);
    }

    public Optional<Branch> getBranch(Long id) {
        return branchRepository.findById(id);
    }

    public void deleteBranch(Long id) {
        branchRepository.deleteById(id);
    }
}
