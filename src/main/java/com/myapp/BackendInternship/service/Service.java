package com.myapp.BackendInternship.service;


import com.myapp.BackendInternship.models.dto.ArticleDTO;
import com.myapp.BackendInternship.models.entity.Article;
import com.myapp.BackendInternship.models.entity.Company;
import com.myapp.BackendInternship.repository.ArticleRepository;
import com.myapp.BackendInternship.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class Service {
    private final
    ArticleRepository articleRepository;
    private final
    CompanyRepository companyRepository;
    private final ModelMapper modelMapper;

    public ArticleDTO createArticle(ArticleDTO articleDTO, long companyId){
        Company company = companyRepository.getById(companyId).get();
        articleDTO.setCompany(company);
        Article mappedClass = modelMapper.map(articleDTO, Article.class);
        return modelMapper.map(articleRepository.save(mappedClass),ArticleDTO.class);
    }

    public ArticleDTO getArticle(long articleId){
        Article article = articleRepository.getArticleById(articleId).get();
        return modelMapper.map(article,ArticleDTO.class);
    }

    public List<ArticleDTO> findAllArticle() {
        List<Article> articleList =articleRepository.findAll();
        return articleList.stream().map(e -> modelMapper.map(e,ArticleDTO.class)).collect(Collectors.toList());

    }

    public List<ArticleDTO> findArticleByCompany(String companyName){
        List<Article> articleList = articleRepository.findArticleByCompany_Name(companyName);
        return articleList.stream().map((e -> modelMapper.map(e,ArticleDTO.class))).collect(Collectors.toList());
    }



    public void deleteArticle(long id){
        articleRepository.deleteById(id);
    }
}
