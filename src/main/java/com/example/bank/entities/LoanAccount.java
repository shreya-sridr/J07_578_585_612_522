package com.banking.bank.entities;

import jakarta.persistence.*;

//Lombok
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("loan")
public class LoanAccount extends Account {
    
}