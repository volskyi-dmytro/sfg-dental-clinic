package com.stpunk47.sfgdentalclinic.controllers;

import com.stpunk47.sfgdentalclinic.services.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping("/find")
    public String findCompanies(){
        return "notImplemented";

    }

    @GetMapping("/{companyId}")
    public ModelAndView showCompany(@PathVariable("companyId") Long companyId){
        ModelAndView mav = new ModelAndView("companies/companyDetails");
        mav.addObject(companyService.findById(companyId));
        return mav;
    }
}
