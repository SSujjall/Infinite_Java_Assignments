package com.main.main.Models.DTOs;

public record BankAccountInsertDTO (
        String accountNumber,
        String accountHolderName,
        double balance
) {}
