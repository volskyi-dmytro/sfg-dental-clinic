package com.stpunk47.sfgdentalclinic.controllers;

import com.stpunk47.sfgdentalclinic.services.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/companies")
@Controller
public class CompaniesController {

    private final CompanyService companyService;

    public CompaniesController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping({"","/","/index", "/index.html"})
    public String listCompanies(Model model){
        model.addAttribute("companies", companyService.findAll());


        return "/companies/index";
    }
}
