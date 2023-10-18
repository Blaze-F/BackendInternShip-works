package com.myapp.BackendInternship.Controller;

import com.myapp.BackendInternship.models.dto.ArticleDTO;
import com.myapp.BackendInternship.models.entity.Article;
import com.myapp.BackendInternship.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private Service service;
    @GetMapping("/company")
    public void getCompany(long id){
    }
    @PostMapping("/article/create")
    public ArticleDTO createArticle(@RequestBody ArticleDTO articleDTO, long companyId){
        return service.createArticle(articleDTO,companyId);
    }

    @GetMapping("/company/list")
    public List<ArticleDTO> findAllArticle() {
        return service.findAllArticle();
    }



}
