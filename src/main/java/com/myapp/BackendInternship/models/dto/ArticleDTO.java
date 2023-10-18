package com.myapp.BackendInternship.models.dto;

import com.myapp.BackendInternship.models.entity.Company;
import com.myapp.BackendInternship.models.entity.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDTO {

    private Long id;
    private String position;
    private int reward;
    private String describes;

    private Company company;


}
