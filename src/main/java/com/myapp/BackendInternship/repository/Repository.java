package com.myapp.BackendInternship.repository;

import com.myapp.BackendInternship.models.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Repository extends JpaRepository<Article,Long> {

    public Optional<Article> getCompaniesById(long id);

}
