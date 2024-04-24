package com.banking.bank.entities;

import jakarta.persistence.*;

//Lombok
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("current")
public class CurrentAccount extends Account {

}
