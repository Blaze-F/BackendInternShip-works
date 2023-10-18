package com.myapp.BackendInternship.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Entity
public class Company {
    @Id
    private Long id;
    private String name;
    private String nation;
    private String location;

}
