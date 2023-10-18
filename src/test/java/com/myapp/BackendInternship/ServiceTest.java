package com.myapp.BackendInternship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.myapp.BackendInternship.models.dto.ArticleDTO;
import com.myapp.BackendInternship.models.entity.Article;
import com.myapp.BackendInternship.models.entity.Company;
import com.myapp.BackendInternship.repository.ArticleRepository;
import com.myapp.BackendInternship.repository.CompanyRepository;
import com.myapp.BackendInternship.service.Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ServiceTest {

    @InjectMocks
    private Service service;

    @Mock
    private ArticleRepository articleRepository;
    @Mock
    private CompanyRepository companyRepository;

    @Mock
    private ModelMapper modelMapper;



    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateArticle() {
        Company company = Company.builder()
                .id(1L)
                .name("test")
                .build();
        ArticleDTO articleDTO = ArticleDTO
                .builder()
                .id(1L)
                .describes("any")
                .position("any")
                .build();
        Article article = Article.builder()
                .id(1L)
                .company( company)
                .describes("any")
                .position("any")
                .build();

        when(articleRepository.save(article)).thenReturn(article);
        when(companyRepository.getById(1L)).thenReturn(Optional.ofNullable(company));
        when(modelMapper.map(any(),eq(Article.class))).thenReturn(article);
        when(modelMapper.map(any(),eq(ArticleDTO.class))).thenReturn((articleDTO));

        ArticleDTO result = service.createArticle(articleDTO, 1L);

         assertEquals(articleDTO, result);
         verify(articleRepository, times(1)).save(article);
    }

    @Test
    public void testGetArticle() {
        long articleId = 1L;
        Company company = Company.builder()
                .id(1L)
                .name("test")
                .build();
        Article article = Article.builder()
                .id(1L)
                .company(company)
                .describes("any")
                .position("any")
                .build();
        ArticleDTO articleDTO = ArticleDTO
                .builder()
                .id(1L)
                .describes("any")
                .position("any")
                .build();

        when(articleRepository.getArticleById(articleId)).thenReturn(Optional.of(article));
        when(modelMapper.map(any(),eq(Article.class))).thenReturn(article);
        when(modelMapper.map(any(),eq(ArticleDTO.class))).thenReturn((articleDTO));

        ArticleDTO result = service.getArticle(articleId);

        assertEquals(articleDTO.getId(), result.getId());
        assertEquals(articleDTO.getDescribes(), result.getDescribes());
        assertEquals(articleDTO.getPosition(), result.getPosition());
        verify(articleRepository, times(1)).getArticleById(articleId);
        verify(modelMapper, times(1)).map(article, ArticleDTO.class);
    }

    @Test
    public void testFindAllArticle() {
        Company company = Company.builder()
                .id(1L)
                .name("test")
                .build();
        Article article = Article.builder()
                .id(1L)
                .company(company)
                .describes("any")
                .position("any")
                .build();
        ArticleDTO articleDTO = ArticleDTO
                .builder()
                .id(1L)
                .describes("any")
                .position("any")
                .build();
        List<Article> articles = new ArrayList<>();
        articles.add(article);
        articles.add(article);

        when(articleRepository.findAll()).thenReturn(articles);
        when(modelMapper.map(any(),eq(Article.class))).thenReturn(article);
        when(modelMapper.map(any(),eq(ArticleDTO.class))).thenReturn((articleDTO));

        List<ArticleDTO> result = service.findAllArticle();

        verify(articleRepository, times(1)).findAll();
        verify(modelMapper, times(articles.size())).map(any(), eq(ArticleDTO.class));
    }

    @Test
    public void testFindArticleByCompany() {
        Company company = Company.builder()
                .id(1L)
                .name("test")
                .build();
        Article article = Article.builder()
                .id(1L)
                .company(company)
                .describes("any")
                .position("any")
                .build();
        ArticleDTO articleDTO = ArticleDTO
                .builder()
                .id(1L)
                .describes("any")
                .position("any")
                .build();
        List<Article> articles = new ArrayList<>();
        articles.add(article);
        articles.add(article);

        when(articleRepository.findArticleByCompany_Name("test")).thenReturn(articles);
        when(modelMapper.map(any(),eq(Article.class))).thenReturn(article);
        when(modelMapper.map(any(),eq(ArticleDTO.class))).thenReturn((articleDTO));

        List<ArticleDTO> result = service.findArticleByCompany("test");

        verify(articleRepository, times(1)).findArticleByCompany_Name("test");
        verify(modelMapper, times(articles.size())).map(any(), eq(ArticleDTO.class));
    }

    @Test
    public void testDeleteArticle() {
        long articleId = 1L;

        service.deleteArticle(articleId);

        // Verify that the deleteById method of articleRepository is called once with the correct argument
        verify(articleRepository, times(1)).deleteById(articleId);
    }
}
