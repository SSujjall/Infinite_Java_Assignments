package com.main.main.API.DTOs.Bank;

import com.main.main.API.DTOs.Users.CreateUserDTO;
import com.main.main.Domain.Enums.AccountType;
import com.main.main.Domain.Enums.CurrencyType;
import lombok.Builder;

@Builder
public record CreateBankAccountDTO(
    AccountType accountType,
    CurrencyType currency,
    String username,
    String email,
    String password,
    String firstName,
    String lastName,
    String phoneNumber,
    Long roleId
) {}
