package com.main.main.Services;

import com.main.main.Application.Interface.IRepositories.IUserRepository;
import com.main.main.Application.Interface.IServices.IUserService;
import com.main.main.Domain.Entities.Users;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    private final IUserRepository userRepo;

    public UserService(IUserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public Users GetDetailsById(Long userId) {
        // yesle Optional<Users> dinxa if 'orElse' user garena vane.
        return userRepo.findById(userId).orElse(null);
    }
}
