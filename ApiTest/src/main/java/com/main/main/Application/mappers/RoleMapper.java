package com.main.main.Application.mappers;

import com.main.main.API.DTOs.Role.CreateRoleDTO;
import com.main.main.Domain.Entities.Roles;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {
    public Roles mapToModel(CreateRoleDTO dto) {
        if (dto == null) {
            return null;
        }

        return Roles.builder()
                .roleName(dto.roleName().toUpperCase())
                .build();
    }
}
