package org.communityconnectionapp.controller;

import org.communityconnectionapp.dto.UserDto;
import org.communityconnectionapp.dto.UserProfileUpdateDto;
import org.communityconnectionapp.dto.UserRegistrationDto;
import org.communityconnectionapp.entity.User;
import org.communityconnectionapp.entity.enums.RoleType;
import org.communityconnectionapp.exception.ResourceNotFoundException;
import org.communityconnectionapp.repository.UserRepository;
import org.communityconnectionapp.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController extends UserMapper{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRegistrationDto userDto) {

        if (userRepository.existsUserByUsername(userDto.getUsername())) {
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
    }

    @GetMapping("/profile")
    public ResponseEntity<UserDto> getUserProfile(@AuthenticationPrincipal UserServiceImpl userService) {
        User user = userRepository.findById(userService.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userService.getId()));

        UserDto userDto = convertToDto(user);

        return ResponseEntity.ok(userDto);
    }

    @PutMapping("/profile")
    public ResponseEntity<UserDto> updateUserProfile(@AuthenticationPrincipal UserServiceImpl userService,
                                                     @Valid @RequestBody UserProfileUpdateDto userProfileUpdateDto) {
        User user = userRepository.findById(userService.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userService.getId()));

        // Update user information
        user.setName(userProfileUpdateDto.getName());
        user.setEmail(userProfileUpdateDto.getEmail());
        user.setPhoneNumber(userProfileUpdateDto.getPhoneNumber());

        User updatedUser = userRepository.save(user);
        UserDto updatedUserDto = convertToDto(updatedUser);

        return ResponseEntity.ok(updatedUserDto);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(@AuthenticationPrincipal UserServiceImpl userService) {
        List<User> users = userRepository.findAll();

        return ResponseEntity.ok(users);
    }
}
