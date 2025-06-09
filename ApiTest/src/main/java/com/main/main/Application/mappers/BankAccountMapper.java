package com.main.main.Application.mappers;

import com.main.main.Application.DTOs.Bank.BankAccountInsertDTO;
import com.main.main.Domain.Entities.BankAccount;
import org.springframework.stereotype.Component;

@Component
public class BankAccountMapper {
    public BankAccount mapToModel(BankAccountInsertDTO dto) {
        if (dto == null) {
            return null;
        }

        return BankAccount.builder()
                .accountNumber(dto.accountNumber())
                .balance(dto.balance())
                .build();
    }

    public BankAccountInsertDTO mapToDto(BankAccount model) {
        if (model == null) {
            return null;
        }

        return BankAccountInsertDTO.builder()
                .accountNumber(model.getAccountNumber())
                .balance(model.getBalance())
                .build();
    }
}
