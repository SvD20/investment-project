package com.svyatdanilov.investmentproject.service;


import com.svyatdanilov.investmentproject.dto.UserDto;
import com.svyatdanilov.investmentproject.entity.User;

import java.util.List;


public interface UserDtoService {

    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();

}
