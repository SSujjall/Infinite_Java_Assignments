package com.main.main.Services;

import com.main.main.API.DTOs.Bank.CreateBankAccountDTO;
import com.main.main.API.DTOs.Bank.UpdateBankAccountDTO;
import com.main.main.Application.Interface.IRepositories.IBankAccountRepository;
import com.main.main.Application.Interface.IRepositories.IUserRepository;
import com.main.main.Application.Interface.IRepositories.IRoleRepository;
import com.main.main.Application.Interface.IRepositories.IUserRoleRepository;
import com.main.main.Application.Interface.IServices.IBankAccountService;
import com.main.main.Domain.Entities.BankAccount;
import com.main.main.Domain.Entities.Customers;
import com.main.main.Domain.Entities.Roles;
import com.main.main.Domain.Entities.UserRole;
import com.main.main.Domain.Enums.AccountType;
import com.main.main.Domain.Enums.CurrencyType;
import com.main.main.Domain.Shared.UserRoleId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BankAccountService implements IBankAccountService {
    private final IBankAccountRepository bankAccRepo;
    private final IUserRepository customerRepo;
    private final IRoleRepository roleRepo;
    private final IUserRoleRepository userRoleRepo;

    @Override
    public BankAccount CreateNewAccount(CreateBankAccountDTO dto) {
        Customers customer = Customers.builder()
                .username(dto.username())
                .email(dto.email())
                .password(dto.password())
                .firstName(dto.firstName())
                .lastName(dto.lastName())
                .phoneNumber(dto.phoneNumber())
                .customerCode(System.currentTimeMillis())
                .build();
        var savedCustomer = customerRepo.save(customer);

        Roles role = roleRepo.findById(dto.roleId()).orElse(null);

        UserRole userRole = new UserRole(
            new UserRoleId(savedCustomer.getUserId(), role.getRoleId()),
            savedCustomer,
            role
        );

        userRoleRepo.save(userRole);

        String accountNumber;
        if (dto.accountType() == AccountType.CURRENT) {
            accountNumber = "1330-" + UUID.randomUUID().toString();
        } else {
            accountNumber = "1220-" + UUID.randomUUID().toString();
        }

        BankAccount account = BankAccount.builder()
                .accountNumber(accountNumber)
                .accountType(AccountType.valueOf(String.valueOf(dto.accountType())))
                .currency(CurrencyType.valueOf(String.valueOf(dto.currency())))
                .user(savedCustomer)
                .build();

        return bankAccRepo.save(account);
    }

    @Override
    public Iterable<BankAccount> GetAllAccounts() {
        var allAccounts = bankAccRepo.findAll();
        if (allAccounts == null) {
            return null;
        }
        return allAccounts;
    }

    @Override
    public BankAccount GetAccountById() {
        return null;
    }

    @Override
    public BankAccount UpdateAccount(UpdateBankAccountDTO dto) {
        var account = bankAccRepo.findByAccountNumber(dto.accountNumber());

        if (account == null) {
            return null;
        }

//        /// This creates an entierly new object
//        var updatedAccount = account.builder()
//                .accountId(account.getAccountId())
//                .accountNumber(account.getAccountNumber())
//                .accountType(dto.accountType())
//                .currency(account.getCurrency())
//                .users(account.getUsers())
//                .build();

        account.setAccountType(dto.accountType());
        return bankAccRepo.save(account);
    }
}
