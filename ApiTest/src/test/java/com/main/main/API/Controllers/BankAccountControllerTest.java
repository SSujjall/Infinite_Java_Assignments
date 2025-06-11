package com.main.main.API.Controllers;

import com.main.main.API.DTOs.Bank.CreateBankAccountDTO;
import com.main.main.API.ResponseModel.ApiResponse;
import com.main.main.Application.Interface.IServices.IBankAccountService;
import com.main.main.Domain.Entities.BankAccount;
import com.main.main.Domain.Entities.Customers;
import com.main.main.Domain.Enums.AccountType;
import com.main.main.Domain.Enums.CurrencyType;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.sameInstance;

class BankAccountControllerTest {
    // Using JMock for mocking
    private Mockery context;
    private IBankAccountService bankAccountService;
    private BankAccountController bankAccountController;

    @BeforeEach
    public void setup() {
        context = new Mockery();
        bankAccountService = context.mock(IBankAccountService.class);
        bankAccountController = new BankAccountController(bankAccountService);
    }

    @Test
    void createNewAccount() {
        // ARRANGE
        Customers customerResModel = new Customers();
        customerResModel.setUsername("test");
        customerResModel.setEmail("test@gmail.com");
        customerResModel.setPassword("test123");
        customerResModel.setFirstName("Test");
        customerResModel.setLastName("User");
        customerResModel.setPhoneNumber("1234567890");
        customerResModel.setCustomerCode(2L);


        BankAccount bankResModel = new BankAccount();
        bankResModel.setAccountNumber("acc1004010");
        bankResModel.setUser(customerResModel);

        CreateBankAccountDTO mockDTO = CreateBankAccountDTO.builder()
                        .accountType(AccountType.SAVING)
                        .currency(CurrencyType.NPR)
                        .username("test")
                        .email("test@gmail.com")
                        .password("test123")
                        .firstName("Test")
                        .lastName("User")
                        .phoneNumber("1234567890")
                        .roleId(1L)
                        .build();

        /// setting what should we expect for return value
        context.checking(new Expectations() {{
            oneOf(bankAccountService).CreateNewAccount(with(sameInstance(mockDTO)));
            will(returnValue(bankResModel));
        }});

        // ACT
        ResponseEntity<ApiResponse<BankAccount>> response = bankAccountController.CreateNewAccount(mockDTO);

        // ASSERT
        assertNotNull(response.getBody());
        assertEquals("acc1004010", response.getBody().getData().getAccountNumber());

        /// Verifying if all teh expectations were met
        context.assertIsSatisfied();
    }
}