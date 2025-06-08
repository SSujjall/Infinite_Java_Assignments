package com.main.main.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @GetMapping("/api/SayYo")
    public String SayYo() {
        return "Hello world";
    }

    @PostMapping("/api/Greet")
    public String Greet(@RequestParam String name) {
        return "Hello " + name;
    }
}