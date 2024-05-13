package com.inkhyang.userservice.controller;

import com.inkhyang.userservice.entity.UserEntity;
import com.inkhyang.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;

    @GetMapping("/users")
    public List<UserEntity> allUsers(){
        return userService.getAll();
    }
}
