package com.main.main.Services;

import com.main.main.API.DTOs.Bank.CreateBankAccountDTO;
import com.main.main.API.DTOs.Bank.UpdateBankAccountDTO;
import com.main.main.API.DTOs.Users.CreateUserDTO;
import com.main.main.Application.Interface.IRepositories.IBankAccountRepository;
import com.main.main.Application.Interface.IRepositories.IUserRepository;
import com.main.main.Application.Interface.IServices.IBankAccountService;
import com.main.main.Domain.Entities.BankAccount;
import com.main.main.Domain.Entities.Users;
import com.main.main.Domain.Enums.AccountType;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BankAccountService implements IBankAccountService {
    private final IBankAccountRepository bankAccRepo;
    private final IUserRepository userRepo;

    public BankAccountService(IBankAccountRepository bankAccRepo, IUserRepository userRepo) {
        this.bankAccRepo = bankAccRepo;
        this.userRepo = userRepo;
    }

    @Override
    public BankAccount CreateNewAccount(CreateBankAccountDTO dto) {
        CreateUserDTO userDto = dto.user();

//        Users userModel = new Users();
//        userModel.setUsername(userDto.username());
//        userModel.setPassword(userDto.password());
//        userModel.setFirstName(userDto.firstName());
//        userModel.setLastName(userDto.lastName());
//        userModel.setEmail(userDto.email());
//        userModel.setPhoneNumber(userDto.phoneNumber());
//        userModel.setUserType(userDto.userType());

        Users userModel = Users.builder()
                .username(userDto.username())
                .password(userDto.password())
                .firstName(userDto.firstName())
                .lastName(userDto.lastName())
                .email(userDto.email())
                .phoneNumber(userDto.phoneNumber())
                .userType(userDto.userType())
                .build();

        var savedUser = userRepo.save(userModel);

        String accountNumber;
        if (dto.accountType() == AccountType.CURRENT) {
            accountNumber = "1330-" + UUID.randomUUID().toString();
        } else {
            accountNumber = "1220-" + UUID.randomUUID().toString();
        }

        BankAccount bankAccount = BankAccount.builder()
                .accountNumber(accountNumber)
                .accountType(dto.accountType())
                .currency(dto.currency())
                .users(savedUser)
                .build();

        return bankAccRepo.save(bankAccount);
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
