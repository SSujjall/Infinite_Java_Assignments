package com.main.main.API.Controllers;

import com.main.main.API.ResponseModel.ApiResponse;
import com.main.main.Application.Interface.IServices.IUserService;
import com.main.main.Domain.Shared.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/User")
public class UserController {
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("get-by-id")
    public ResponseEntity<ApiResponse<Users>> GetById(@RequestParam Long userId) {
        var response = userService.GetDetailsById(userId);
        if (response == null) {
            return ResponseEntity.ok(ApiResponse.failed("No user found"));
        }
        return ResponseEntity.ok(ApiResponse.success(response, "fetched"));
    }
}
