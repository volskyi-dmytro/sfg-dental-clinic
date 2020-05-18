package com.stpunk47.sfgdentalclinic.controllers;

import com.stpunk47.sfgdentalclinic.model.Company;
import com.stpunk47.sfgdentalclinic.services.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;


@RequestMapping("/companies")
@Controller
public class CompaniesController {

    private static final String VIEWS_COMPANIES_CREATE_OR_UPDATE_FORM = "companies/createOrUpdateCompanyForm";
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
        List<Company> results = companyService.findAllByLastNameLike("%"+company.getLastName()+"%");

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
    public ModelAndView showCompany(@PathVariable Long companyId){
        ModelAndView mav = new ModelAndView("companies/companyDetails");
        mav.addObject(companyService.findById(companyId));
        return mav;
    }

    @GetMapping("/new")
    public String initCreationForm(Model model){
        model.addAttribute("company", Company.builder().build());
        return VIEWS_COMPANIES_CREATE_OR_UPDATE_FORM;
    }
    @PostMapping("/new")
    public String processCreationForm(@Valid Company company, BindingResult result){
        if(result.hasErrors()){
            return VIEWS_COMPANIES_CREATE_OR_UPDATE_FORM;
        } else {
            Company savedCompany = companyService.save(company);
            return "redirect:/companies/" + savedCompany.getId();
        }
    }

    @GetMapping("/{companyId}/edit")
    public String initUpdateCompanyForm(@PathVariable Long companyId, Model model){
        model.addAttribute(companyService.findById(companyId));
        return VIEWS_COMPANIES_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/{companyId}/edit")
    public String processUpdateCompanyForm(@Valid Company company,
                                           BindingResult result,
                                           @PathVariable Long companyId){
        if(result.hasErrors()){
            return VIEWS_COMPANIES_CREATE_OR_UPDATE_FORM;
        } else {
            company.setId(companyId);
            Company savedCompany =  companyService.save(company);
            return "redirect:/companies/" + savedCompany.getId();
        }
    }


}
