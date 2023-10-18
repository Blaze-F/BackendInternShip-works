package com.myapp.BackendInternship.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.springframework.stereotype.Component;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Builder
public class Article {
    @Id
    private Long id;
    private String position;
    private int reward;
    private String describes;

    @ManyToOne
    User user;
    @ManyToOne
    Company company;
}
