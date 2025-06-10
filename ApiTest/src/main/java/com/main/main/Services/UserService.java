package com.main.main.Services;

import com.main.main.Application.Interface.IRepositories.ICustomerRepository;
import com.main.main.Application.Interface.IServices.IUserService;
import com.main.main.Domain.Shared.Users;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    private final ICustomerRepository userRepo;

    public UserService(ICustomerRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public Users GetDetailsById(Long userId) {
        // yesle Optional<Users> dinxa if 'orElse' user garena vane.
        return userRepo.findById(userId).orElse(null);
    }
}
