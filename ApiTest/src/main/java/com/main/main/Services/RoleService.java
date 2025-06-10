package com.main.main.Services;

import com.main.main.API.DTOs.Role.CreateRoleDTO;
import com.main.main.Application.Interface.IRepositories.IRoleRepository;
import com.main.main.Application.Interface.IServices.IRoleService;
import com.main.main.Application.mappers.RoleMapper;
import com.main.main.Domain.Entities.Roles;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IRoleService {
    private final IRoleRepository repo;
    private final RoleMapper mapper;


    public RoleService(IRoleRepository repo, RoleMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public Roles CreateNewRole(CreateRoleDTO dto) {
        var roleModel = mapper.mapToModel(dto);
        return repo.save(roleModel);
    }

    @Override
    public List<Roles> GetAllRoles() {
        return repo.findAll();
    }
}
