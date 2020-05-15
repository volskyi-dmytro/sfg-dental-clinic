package com.stpunk47.sfgdentalclinic.controllers;

import com.stpunk47.sfgdentalclinic.model.Company;
import com.stpunk47.sfgdentalclinic.model.Department;
import com.stpunk47.sfgdentalclinic.model.Worker;
import com.stpunk47.sfgdentalclinic.services.CompanyService;
import com.stpunk47.sfgdentalclinic.services.DepartmentService;
import com.stpunk47.sfgdentalclinic.services.WorkerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@Controller
@RequestMapping("/companies/{companyId}")
public class WorkerController {

    private static final String VIEWS_WORKERS_CREATE_OR_UPDATE_FORM = "workers/createOrUpdateWorkerForm";
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
    public Company findCompany(@PathVariable("companyId") Long companyId){
        return companyService.findById(companyId);
    }

    @InitBinder("company")
    public void initCompanyBinder(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping("/workers/new")
    public String initCreationForm(Company company, Model model){
        Worker worker = new Worker();
        company.getWorkers().add(worker);
        worker.setCompany(company);

        model.addAttribute("worker", worker);
        return VIEWS_WORKERS_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/workers/new")
    public String processCreationForm(Company company,
                                      @Valid Worker worker,
                                      BindingResult result,
                                      Model model){
        if (StringUtils.hasLength(worker.getFirstName())
                && worker.isNew()
                && company.getWorker(worker.getFirstName(), worker.getLastName(), true ) != null ){
            result.rejectValue("First name", "duplicate", "already exists");
        }
        company.getWorkers().add(worker);
        if (result.hasErrors()){
            model.addAttribute("worker", worker);
            return VIEWS_WORKERS_CREATE_OR_UPDATE_FORM;
        } else {
            workerservice.save(worker);
            return "redirect:/companies/" + company.getId();
        }
    }

    @GetMapping("/workers/{workerId}/edit")
    public String initUpdateForm(@PathVariable Long workerId, Model model){
        model.addAttribute("worker", workerservice.findById(workerId));
        return VIEWS_WORKERS_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/workers/{workerId}/edit")
    public String processUpdateForm(@Valid Worker worker, BindingResult result, Company company, Model model){
        if( result.hasErrors()){
            worker.setCompany(company);
            model.addAttribute("worker", worker);
            return VIEWS_WORKERS_CREATE_OR_UPDATE_FORM;
        } else {
            company.getWorkers().add(worker);
            workerservice.save(worker);
            return "redirect:/companies/" + company.getId();
        }
    }

}
