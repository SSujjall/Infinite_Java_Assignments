package com.main.main.Domain.Entities;

import com.main.main.Domain.Enums.AccountType;
import com.main.main.Domain.Enums.CurrencyType;
import com.main.main.Domain.Shared.Audit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount extends Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountId;

    @Column(nullable = false, unique = true)
    private String accountNumber;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    private double balance = 0;
    private CurrencyType currency;

    @ManyToOne
    private Users users;

//    // Override the toString() method to print the value in this format in BankManagerService's ViewAllUser Method
//    @Override
//    public String toString(){
//        return "\nAccountNumber: " + accountNumber +
//                "\nName: " + accountHolderName +
//                "\nBalance: " + balance;
//    }
}
