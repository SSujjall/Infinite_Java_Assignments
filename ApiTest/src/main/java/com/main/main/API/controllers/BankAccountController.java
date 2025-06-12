package com.main.main.API.Controllers;

import com.main.main.API.DTOs.Bank.CreateBankAccountDTO;
import com.main.main.API.DTOs.Bank.UpdateBankAccountDTO;
import com.main.main.API.ResponseModel.ApiResponse;
import com.main.main.Application.Interface.IServices.IBankAccountService;
import com.main.main.Domain.Entities.BankAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/BankAccount")
@RequiredArgsConstructor
public class BankAccountController {
    private final IBankAccountService service;

    @GetMapping("get-all-accounts")
    public ResponseEntity<ApiResponse<Iterable<BankAccount>>> GetAllAccount() {
        var response = service.GetAllAccounts();
        if (response == null || !response.iterator().hasNext()) {
            return ResponseEntity.ok(ApiResponse.failed("No Accounts"));
        }
        return ResponseEntity.ok(ApiResponse.success(response, "fetched all records"));
    }

    @PostMapping("create-new-account")
    public ResponseEntity<ApiResponse<BankAccount>> CreateNewAccount(@RequestBody CreateBankAccountDTO model) {
        try {
            var response = service.CreateNewAccount(model);
            if (response != null) {
                return ResponseEntity.ok(ApiResponse.success(response, "created new user"));
            }

            return ResponseEntity.ok(ApiResponse.failed("Failed to create account."));
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.failed("FAiled with exception: " + e.getMessage()));
        }
    }

    @PatchMapping("update-account-type")
    public ResponseEntity<ApiResponse<BankAccount>> UpdateAccountDetails(@RequestBody UpdateBankAccountDTO model) {
        try {
            var response = service.UpdateAccount(model);
            if (response == null) {
                return ResponseEntity.ok(ApiResponse.failed("failed to update account"));
            }
            return ResponseEntity.ok(ApiResponse.success(response, "updated account"));
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.failed("Failed with exception: " + e.getMessage()));
        }
    }

    @PreAuthorize("hasRole('admin')")
    @GetMapping("/only-admin-can-access")
    public ResponseEntity<String> adminEndpoint() {
        return ResponseEntity.ok("You're an admin!");
    }
}
