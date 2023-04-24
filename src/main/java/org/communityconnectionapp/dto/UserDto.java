package org.communityconnectionapp.dto;

import lombok.Data;
import org.communityconnectionapp.entity.enums.RoleType;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String name;
    private String email;
    private String phoneNumber;
    private RoleType roleType;

    public UserDto() {}

    public UserDto(Long id, String username, String name, String email, String phoneNumber, RoleType roleType) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.roleType = roleType;
    }

    // getters and setters
}