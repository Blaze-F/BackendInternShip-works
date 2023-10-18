package com.myapp.BackendInternship.Controller;

import com.myapp.BackendInternship.models.dto.ArticleDTO;
import com.myapp.BackendInternship.models.entity.Article;
import com.myapp.BackendInternship.service.Service;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/article/find")
    public List<ArticleDTO> articleDTOList(HttpServletRequest request){
        String companyName = request.getParameter("name");
        return service.findArticleByCompany(companyName);
    }

    @GetMapping("/company/list")
    public List<ArticleDTO> findAllArticle() {
        return service.findAllArticle();
    }

    @DeleteMapping("/article/delete")
    public String deleteArticle(long id) {

        return id + "delete succeed";
    }
    @PutMapping("/company/edit")
    public ArticleDTO editArticle(@RequestBody ArticleDTO articleDTO, long articleId){
        return service.editArticle(articleDTO,articleId);
    }

}
