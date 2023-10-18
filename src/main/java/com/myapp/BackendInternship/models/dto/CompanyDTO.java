package com.myapp.BackendInternship.models.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyDTO {

    private Long id;
    private String name;
    private String nation;
    private String location;

}
