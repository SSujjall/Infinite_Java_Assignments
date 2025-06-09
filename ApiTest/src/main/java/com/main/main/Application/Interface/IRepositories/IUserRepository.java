package com.main.main.Application.Interface.IRepositories;

import com.main.main.Domain.Entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<Users, Long> {

}
