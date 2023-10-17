package com.myapp.BackendInternship.Controller;

import com.myapp.BackendInternship.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private Service service;
    public void get_company(long id){
    }
}
