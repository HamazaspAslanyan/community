package org.communityconnectionapp.service;

import jdk.jshell.spi.ExecutionControl;
import lombok.AllArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.communityconnectionapp.dto.UserDto;
import org.communityconnectionapp.dto.UserProfileUpdateDto;
import org.communityconnectionapp.dto.UserRegistrationDto;
import org.communityconnectionapp.entity.User;
import org.communityconnectionapp.entity.enums.RoleType;
import org.communityconnectionapp.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService  {

    private final UserRepository userRepository;

    private final MapperFacade mapper;

    @Override
    public User getUserById(Long userId) {
        final User user = userRepository.findById(userId)
                .orElseThrow(() -> new ExecutionControl.UserException(ErrorCode.USER_NOT_FOUND));

        if (!user.isActive()) {
            throw new ExecutionControl.UserException(ErrorCode.USER_IS_BLOCKED);
        }

        return user;
    }

    @Override
    public UserDto createUser(UserRegistrationDto userRegDto) {

        final User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserException(ErrorCode.USER_NOT_FOUND));

        if (user.isBlock()) {
            throw new UserException(ErrorCode.USER_IS_BLOCKED);
        }

        return user;

        if (userRepository.existsUserByUsername(userRegDto.getUsername())) {
            return ResponseEntity.badRequest().body("Username already exists");
        }

        if (userRepository.existsUserByEmail(userDto.getEmail())) {
            return ResponseEntity.badRequest().body("Email already exists");
        }

        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setRoleType(RoleType.USER);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        userRepository.save(user);

        return ResponseEntity.ok("User registered successfully");
        return null;
    }

    @Override
    public UserDto updateUser(UserProfileUpdateDto userProfileUpdateDto) {
        return null;
    }

    @Override
    public UserDto deactivateUser(Long userId) {
        return null;
    }
}
