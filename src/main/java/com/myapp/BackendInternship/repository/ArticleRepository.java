package com.myapp.BackendInternship.repository;

import com.myapp.BackendInternship.models.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article,Long> {

    public Optional<Article> getArticleById(long id);
    public List<Article> findArticleByCompany_Name(String name);
    public void deleteById(long id);

}
