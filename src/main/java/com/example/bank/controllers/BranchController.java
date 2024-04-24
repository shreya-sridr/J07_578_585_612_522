package com.banking.bank.controllers;

import com.banking.bank.entities.Branch;
import com.banking.bank.services.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/branches")
public class BranchController {

    @Autowired
    private BranchService branchService;

    @PostMapping("/{bankId}")
    public Branch createBranch(@RequestBody Branch branch, @PathVariable Long bankId) {
        return branchService.createBranch(branch, bankId);
    }

    @GetMapping("/{id}")
    public Branch getBranch(@PathVariable Long id) {
        return branchService.getBranch(id).orElseThrow(() -> new RuntimeException("Branch not found"));
    }

    @DeleteMapping("/{id}")
    public void deleteBranch(@PathVariable Long id) {
        branchService.deleteBranch(id);
    }
}
