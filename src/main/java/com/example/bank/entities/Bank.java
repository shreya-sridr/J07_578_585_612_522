package com.banking.bank.entities;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Getter
@Setter
@Entity
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String bankName;
    public String location;

    @JsonIgnore
    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL)
    public List<Branch> branches = new ArrayList<>();

    public int getNumberOfBranches() {
        return branches != null ? branches.size() : 0;
    }
}
