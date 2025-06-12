package com.main.main.API.Controllers;
import com.main.main.API.DTOs.Bank.CreateBankAccountDTO;
import com.main.main.Domain.Entities.BankAccount;
import com.main.main.Application.Interface.IRepositories.IBankAccountRepository;
import com.main.main.Application.mappers.BankAccountMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Test")
public class TestController {

    private final IBankAccountRepository repo;
    private final BankAccountMapper mapper;

    public TestController(IBankAccountRepository repo, BankAccountMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @PostMapping("GetAll")
    public List<BankAccount> GetAll() {
        var x = repo.findAll();
        return x;
    }

    @PostMapping("GetByAccNumber")
    public BankAccount GetByAccNum(@RequestBody String accNum) {
        var x = repo.findByAccountNumber(accNum);
        return x;
    }

    @PostMapping("Insert")
    public BankAccount Insert(@RequestBody CreateBankAccountDTO model) {
        BankAccount account = mapper.mapToModel(model);
        return repo.save(account);
    }
}