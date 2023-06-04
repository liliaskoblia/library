package com.example.library.services;

import com.example.library.model.dto.security.UserDto;
import com.example.library.model.security.User;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);
}