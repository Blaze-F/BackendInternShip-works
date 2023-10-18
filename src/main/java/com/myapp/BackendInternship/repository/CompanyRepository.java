package com.myapp.BackendInternship.repository;

import com.myapp.BackendInternship.models.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company,Long> {
    Optional<Company> getById(long id);
    List<Company> findCompanyByName(String name);
}
