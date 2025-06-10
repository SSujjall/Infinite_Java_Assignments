package com.main.main.Application.Interface.IRepositories;

import com.main.main.Domain.Entities.Customers;
import com.main.main.Domain.Shared.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customers, Long> {

}
