package com.main.main.Application.Interface.IServices;

import com.main.main.Domain.Shared.Users;

public interface IUserService {
    Users GetDetailsById(Long userId);
}
