package com.main.main.Application.DTOs.Bank;

import lombok.Builder;

@Builder
public record BankAccountInsertDTO (
        String accountNumber,
        String accountHolderName,
        double balance
) {}
