package com.myapp.BackendInternship.service;


import com.myapp.BackendInternship.models.dto.ArticleDTO;
import com.myapp.BackendInternship.models.entity.Article;
import com.myapp.BackendInternship.repository.ArticleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Service {

    ArticleRepository articleRepository;
    ModelMapper modelMapper;
    public ArticleDTO createArticle(ArticleDTO articleDTO, long companyId){
        Article mappedClass = modelMapper.map(articleDTO, Article.class);
        return new ArticleDTO(modelMapper.map(repository.save(mappedClass),ArticleDTO.class));
    }

    public ArticleDTO getArticle(long articleId){
        Article article = articleRepository.getArticleById(articleId).get();
        return modelMapper.map(article,ArticleDTO.class);
    }

    public List<ArticleDTO> findAllArticle() {
        List<Article> articleList =articleRepository.findAll();

    }

    public List<ArticleDTO> findArticleByCompany(String companyName){
        List<Article> articleList = articleRepository.findArticleByCompany_Name(companyName);
    }

}
