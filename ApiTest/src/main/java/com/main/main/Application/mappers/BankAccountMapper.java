package com.main.main.Application.mappers;

import com.main.main.API.DTOs.Bank.CreateBankAccountDTO;
import com.main.main.Domain.Entities.BankAccount;
import org.springframework.stereotype.Component;

@Component
public class BankAccountMapper {
    public BankAccount mapToModel(CreateBankAccountDTO dto) {
        if (dto == null) {
            return null;
        }

        return BankAccount.builder()
                .build();
    }

    public CreateBankAccountDTO mapToDto(BankAccount model) {
        if (model == null) {
            return null;
        }

        return CreateBankAccountDTO.builder()
                .build();
    }
}
