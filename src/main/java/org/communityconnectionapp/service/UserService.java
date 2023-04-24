package org.communityconnectionapp.service;

import org.communityconnectionapp.dto.UserDto;
import org.communityconnectionapp.dto.UserProfileUpdateDto;
import org.communityconnectionapp.dto.UserRegistrationDto;
import org.communityconnectionapp.entity.User;

import java.util.List;

public interface UserService {

    public User getUserById(Long userId);

//    public List<UserDto> getUsers()

    public UserDto createUser(UserRegistrationDto userRegDto);

    public UserDto updateUser(UserProfileUpdateDto userProfileUpdateDto);

    public UserDto deactivateUser(Long userId);

}
