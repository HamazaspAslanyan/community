package org.communityconnectionapp.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "parking_places")
public class ParkingPlace extends BaseEntity{

    @Column(name = "parking_id", nullable = false)
    private Long parkingId;


    @Column(name = "number", nullable = false)
    private String number;
}
