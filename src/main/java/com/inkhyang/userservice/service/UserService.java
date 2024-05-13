package com.inkhyang.userservice.service;

import com.inkhyang.userservice.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> getAll();
}
