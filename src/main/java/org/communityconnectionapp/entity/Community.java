package org.communityconnectionapp.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "communities")
public class Community extends BaseEntity{

    @Column(name = "name", nullable = false)
    private String name;


    @Column(name = "address", nullable = false)
    private String address;
}
