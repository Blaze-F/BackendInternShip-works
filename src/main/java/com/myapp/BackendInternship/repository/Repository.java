package com.myapp.BackendInternship.repository;

import com.myapp.BackendInternship.models.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface Repository extends JpaRepository<Company,Long> {

    public Optional<Company> getCompaniesById(long id);

}
