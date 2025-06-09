package com.main.main.mappers;

import ch.qos.logback.core.model.Model;
import com.main.main.Models.DTOs.BankAccountInsertDTO;
import com.main.main.Models.Entities.BankAccount;
import org.springframework.stereotype.Component;

@Component
public class BankAccountMapper {
    public BankAccount mapToModel(BankAccountInsertDTO dto) {
        if (dto == null) {
            return null;
        }

        return BankAccount.builder()
                .accountNumber(dto.accountNumber())
                .accountHolderName(dto.accountHolderName())
                .balance(dto.balance())
                .build();
    }
}
