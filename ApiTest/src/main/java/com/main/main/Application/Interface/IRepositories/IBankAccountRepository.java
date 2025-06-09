package com.main.main.Application.Interface.IRepositories;

import com.main.main.Domain.Entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBankAccountRepository extends JpaRepository<BankAccount, String> {
    BankAccount findByAccountNumber(String accNum);
}
