package com.main.main.API.Controllers;

import com.main.main.API.DTOs.Role.CreateRoleDTO;
import com.main.main.API.ResponseModel.ApiResponse;
import com.main.main.Application.Interface.IServices.IRoleService;
import com.main.main.Domain.Entities.Roles;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Role")
public class RoleController {
    private final IRoleService service;

    public RoleController(IRoleService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Roles>>> GetAllRoles() {
        var response = service.GetAllRoles();
        if (response == null) {
            return ResponseEntity.ok(ApiResponse.failed("Failed to fetch roles."));
        }
        return ResponseEntity.ok(ApiResponse.success(response, "fetched all roles"));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Roles>> CreateRole(@RequestBody CreateRoleDTO model) {
        var response = service.CreateNewRole(model);
        if (response == null) {
            return ResponseEntity.ok(ApiResponse.failed("Failed to create role."));
        }
        return ResponseEntity.ok(ApiResponse.success(response, "Created new role"));
    }
}
