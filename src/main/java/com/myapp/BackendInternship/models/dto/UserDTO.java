package com.myapp.BackendInternship.models.dto;

import com.myapp.BackendInternship.models.entity.Article;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserDTO {

    @Id
    private Long id;

    private String name;
    private String password;


}
