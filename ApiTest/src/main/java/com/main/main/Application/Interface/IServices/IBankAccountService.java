package com.main.main.Application.Interface.IServices;

import com.main.main.API.DTOs.Bank.CreateBankAccountDTO;
import com.main.main.API.DTOs.Bank.UpdateBankAccountDTO;
import com.main.main.Domain.Entities.BankAccount;

public interface IBankAccountService {
    BankAccount CreateNewAccount(CreateBankAccountDTO dto);
    Iterable<BankAccount> GetAllAccounts();
    BankAccount GetAccountById();
    BankAccount UpdateAccount(UpdateBankAccountDTO dto);
}
