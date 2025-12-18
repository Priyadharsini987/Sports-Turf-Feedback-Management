package com.examly.springapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping("/dummy/{id}")
    public String dummy(@PathVariable Long id) {
        return "ok";
    }
}
