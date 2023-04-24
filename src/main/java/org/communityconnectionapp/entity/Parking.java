package org.communityconnectionapp.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "parkings")
public class Parking extends BaseEntity{

    @Column(name = "community_id", nullable = false)
    private Long communityId;

    @Column(name = "description")
    private String description;
}
