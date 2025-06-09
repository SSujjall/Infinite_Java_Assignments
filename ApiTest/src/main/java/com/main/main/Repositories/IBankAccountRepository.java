package com.main.main.Repositories;

import com.main.main.Models.Entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBankAccountRepository extends JpaRepository<BankAccount, String> {
    BankAccount findByAccountNumber(String accNum);
}
