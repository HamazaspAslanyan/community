package org.communityconnectionapp.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "parking_books")
public class ParkingBooks extends BaseEntity{

    @Column(name = "parking_place_id", nullable = false)
    private Long parkingPlaceId;

    @Column(name = "car_number")
    private String carNumber;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "person_id")
    private Long personId;

    @Column(name = "approved_by")
    private Long approvedBy;

    @Column(name = "status")
    private String status;
}
