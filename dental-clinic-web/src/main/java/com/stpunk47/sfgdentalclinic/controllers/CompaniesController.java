package com.stpunk47.sfgdentalclinic.controllers;

import com.stpunk47.sfgdentalclinic.model.Company;
import com.stpunk47.sfgdentalclinic.services.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/companies")
@Controller
public class CompaniesController {

    private final CompanyService companyService;

    public CompaniesController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }

  @RequestMapping({"","/","/index", "/index.html"})
    public String listCompanies(Model model) {
      model.addAttribute("companies", companyService.findAll());


      return "/companies/index";
  }

    @RequestMapping("/find")
    public String findCompanies(Model model){
        model.addAttribute("companies", Company.builder().build());
        return "companies/findCompanies";
    }

    @GetMapping
    public String processFindForm(Company company, BindingResult result, Model model){
        // allow parameterless GET request for /companies to return all records
        if (company.getLastName() == null) {
            company.setLastName(""); // empty string signifies broadest possible search
        }

        // find owners by last name
        List<Company> results = companyService.findAllByLastNameLike(company.getLastName());
        if (results.isEmpty()) {
            // no companies found
            result.rejectValue("lastName", "notFound", "not found");
            return "companies/findCompanies";
        }
        else if (results.size() == 1) {
            // 1 company found
            company = results.get(0);
            return "redirect:/companies/" + company.getId();
        }
        else {
            // multiple companies found
            model.addAttribute("selections", results);
            return "companies/companiesList";
        }
    }

    @GetMapping("/{companyId}")
    public ModelAndView showCompany(@PathVariable("companyId") Long companyId){
        ModelAndView mav = new ModelAndView("companies/companyDetails");
        mav.addObject(companyService.findById(companyId));
        return mav;
    }
}
