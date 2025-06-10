package com.main.main.API.DTOs.Users;

public record CreateUserDTO(
    String username,
    String email,
    String password,
    String firstName,
    String lastName,
    String phoneNumber,
    Long roleId
) {}
