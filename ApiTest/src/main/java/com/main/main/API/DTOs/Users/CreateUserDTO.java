package com.main.main.API.DTOs.Users;

import com.main.main.Domain.Enums.UserType;

public record CreateUserDTO(
    String username,
    String password,
    String firstName,
    String lastName,
    String email,
    String phoneNumber,
    UserType userType
) {}
