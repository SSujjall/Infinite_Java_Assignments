package com.main.main.controllers;
import com.main.main.Models.DTOs.BankAccountInsertDTO;
import com.main.main.Models.Entities.BankAccount;
import com.main.main.Repositories.IBankAccountRepository;
import com.main.main.mappers.BankAccountMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TestController {

    private final IBankAccountRepository repo;
    private final BankAccountMapper mapper;

    public TestController(IBankAccountRepository repo, BankAccountMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @GetMapping("/api/SayYo")
    public String SayYo() {
        return "Hello world";
    }

    @PostMapping("/api/Greet")
    public String Greet(@RequestParam String name) {
        return "Hello " + name;
    }

    @PostMapping("/api/GetAll")
    public List<BankAccount> GetAll() {
        var x = repo.findAll();
        return x;
    }

    @PostMapping("/api/GetByAccNumber")
    public BankAccount GetByAccNum(@RequestBody String accNum) {
        var x = repo.findByAccountNumber(accNum);
        return x;
    }

    @PostMapping("/api/Insert")
    public BankAccount Insert(@RequestBody BankAccountInsertDTO model) {
        BankAccount account = mapper.mapToModel(model);
        return repo.save(account);
    }
}