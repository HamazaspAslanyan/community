package org.communityconnectionapp.controller;

import org.communityconnectionapp.dto.UserDto;
import org.communityconnectionapp.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto convertToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setRoleType(user.getRoleType());
        return userDto;
    }
}
