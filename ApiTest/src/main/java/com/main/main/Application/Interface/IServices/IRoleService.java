package com.main.main.Application.Interface.IServices;

import com.main.main.API.DTOs.Role.CreateRoleDTO;
import com.main.main.Domain.Entities.Roles;

import java.util.List;

public interface IRoleService {
    Roles CreateNewRole(CreateRoleDTO dto);
    List<Roles> GetAllRoles();
}
