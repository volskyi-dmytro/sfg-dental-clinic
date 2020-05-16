package com.stpunk47.sfgdentalclinic.controllers;

import com.stpunk47.sfgdentalclinic.model.Visit;
import com.stpunk47.sfgdentalclinic.model.Worker;
import com.stpunk47.sfgdentalclinic.services.VisitService;
import com.stpunk47.sfgdentalclinic.services.WorkerService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class VisitController {

    private final VisitService visitService;
    private final WorkerService workerService;

    public VisitController(VisitService visitService, WorkerService workerService) {
        this.visitService = visitService;
        this.workerService = workerService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }


    @ModelAttribute("visit")
    public Visit loadWorkerWithVisit(@PathVariable("workerId") Long workerId, Map<String, Object> model) {
        Worker worker = workerService.findById(workerId);
        model.put("worker", worker);
        Visit visit = new Visit();
        worker.getVisits().add(visit);
        visit.setWorker(worker);
        return visit;
    }


    @GetMapping("/companies/*/workers/{workerId}/visits/new")
    public String initNewVisitForm(@PathVariable("workerId") Long workerId, Map<String, Object> model) {
        return "workers/createOrUpdateVisitForm";
    }


    @PostMapping("/companies/{companyId}/workers/{workerId}/visits/new")
    public String processNewVisitForm(@Valid Visit visit, BindingResult result) {
        if (result.hasErrors()) {
            return "workers/createOrUpdateVisitForm";
        }
        else {
            visitService.save(visit);
            return "redirect:/companies/{companyId}";
        }
    }

}
