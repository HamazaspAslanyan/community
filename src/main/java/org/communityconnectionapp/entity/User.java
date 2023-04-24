package org.communityconnectionapp.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.communityconnectionapp.entity.BaseEntity;
import org.communityconnectionapp.entity.enums.RoleType;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "phone_number", unique = true)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_type")
    private RoleType roleType;


}
