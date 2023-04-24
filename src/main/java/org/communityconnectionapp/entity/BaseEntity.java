package org.communityconnectionapp.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PROTECTED)
    private Long id;

    @CreationTimestamp
    @Column(name = "created_date", nullable = false, updatable = false)
    @Setter(AccessLevel.PROTECTED)
    private LocalDateTime createdDate;

    @UpdateTimestamp
    @Column(name = "last_modified_date", nullable = false)
    private LocalDateTime lastModifiedDate;

    @Column(name = "is_active", nullable = false)
    private boolean active = true;

    @PrePersist
    public void prePersist() {
        this.createdDate = LocalDateTime.now();
    }
}

