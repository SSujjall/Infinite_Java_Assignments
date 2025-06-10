package com.main.main.Application.Interface.IRepositories;

import com.main.main.Domain.Entities.UserRole;
import com.main.main.Domain.Shared.UserRoleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRoleRepository extends JpaRepository<UserRole, UserRoleId> {
}
