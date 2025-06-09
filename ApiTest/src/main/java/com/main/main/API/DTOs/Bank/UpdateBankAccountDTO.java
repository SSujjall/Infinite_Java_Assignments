package com.main.main.API.DTOs.Bank;

import com.main.main.Domain.Enums.AccountType;

public record UpdateBankAccountDTO(
    String accountNumber,
    AccountType accountType
) {
}
