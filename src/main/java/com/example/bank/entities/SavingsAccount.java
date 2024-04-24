package com.banking.bank.entities;

import jakarta.persistence.*;

//Lombok
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("savings")
public class SavingsAccount extends Account {

    private double interestRate;

}