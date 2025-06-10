package com.main.main.Domain.Entities;

import com.main.main.Domain.Enums.AccountType;
import com.main.main.Domain.Enums.CurrencyType;
import com.main.main.Domain.Shared.Audit;
import com.main.main.Domain.Shared.Users;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount extends Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountId;

    @Column(nullable = false, unique = true)
    private String accountNumber;

    @Enumerated(EnumType.STRING)
    private AccountType accountType = AccountType.SAVING;

    private double balance = 0;
    private CurrencyType currency = CurrencyType.NPR;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

//    // Override the toString() method to print the value in this format in BankManagerService's ViewAllUser Method
//    @Override
//    public String toString(){
//        return "\nAccountNumber: " + accountNumber +
//                "\nName: " + accountHolderName +
//                "\nBalance: " + balance;
//    }
}
