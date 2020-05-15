package com.stpunk47.sfgdentalclinic.controllers;

import com.stpunk47.sfgdentalclinic.model.Company;
import com.stpunk47.sfgdentalclinic.model.Department;
import com.stpunk47.sfgdentalclinic.services.CompanyService;
import com.stpunk47.sfgdentalclinic.services.DepartmentService;
import com.stpunk47.sfgdentalclinic.services.WorkerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
@RequestMapping("/companies/{companyId}")
public class WorkerController {

    private static final String VIEWS_WORKERS_CREATE_OR_UPDATE_FORM = "/workers/createOrUpdateWorkerForm";
    private final WorkerService workerservice;
    private final CompanyService companyService;
    private final DepartmentService departmentService;

    public WorkerController(WorkerService workerservice,
                            CompanyService companyService,
                            DepartmentService departmentService) {
        this.workerservice = workerservice;
        this.companyService = companyService;
        this.departmentService = departmentService;
    }

    @ModelAttribute("departments")
    public Collection<Department> populateDepartments(){
        return departmentService.findAll();

    }

    @ModelAttribute("company")
    public Company findCompany(@PathVariable Long companyId){
        return companyService.findById(companyId);
    }

    @InitBinder("company")
    public void initCompanyBinder(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }
}
