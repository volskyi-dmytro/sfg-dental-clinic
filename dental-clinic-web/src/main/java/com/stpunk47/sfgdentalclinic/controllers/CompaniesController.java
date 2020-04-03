package com.stpunk47.sfgdentalclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/companies")
@Controller
public class CompaniesController {

    @RequestMapping({"","/","/index", "/index.html"})
    public String listCompanies(){

        return "/companies/index";
    }
}
