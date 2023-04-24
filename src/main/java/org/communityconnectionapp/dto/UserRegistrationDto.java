package org.communityconnectionapp.dto;

import lombok.Data;

@Data
public class UserRegistrationDto {
    private String username;
    private String name;
    private String password;
    private String confirmPassword;
    private String email;
    private String phoneNumber;

}