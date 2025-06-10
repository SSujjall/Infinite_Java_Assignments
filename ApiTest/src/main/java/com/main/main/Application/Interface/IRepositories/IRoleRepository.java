package com.main.main.Application.Interface.IRepositories;

import com.main.main.Domain.Entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Roles, Long> {
}
