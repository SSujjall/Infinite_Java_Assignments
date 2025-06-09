package com.main.main.Models.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // Override the toString() method to print the value in this format in BankManagerService's ViewAllUser Method
    @Override
    public String toString(){
        return "\nAccountNumber: " + accountNumber +
                "\nName: " + accountHolderName +
                "\nBalance: " + balance;
    }
}
