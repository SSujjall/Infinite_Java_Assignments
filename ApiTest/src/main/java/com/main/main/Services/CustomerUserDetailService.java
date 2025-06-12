package com.main.main.Services;

import com.main.main.Application.Interface.IRepositories.ICustomerRepository;
import com.main.main.Domain.Entities.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerUserDetailService implements UserDetailsService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String usernameFromBasicAuth) throws UsernameNotFoundException {
        Long userId;
        try {
            userId = Long.parseLong(usernameFromBasicAuth); // interpret username as userId
        } catch (NumberFormatException e) {
            throw new UsernameNotFoundException("Invalid userId format");
        }

        Customers customer = customerRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return org.springframework.security.core.userdetails.User
                .withUsername(String.valueOf(customer.getUserId()))
                .password(customer.getPassword())
                .roles("USER")
                .build();
    }
}
