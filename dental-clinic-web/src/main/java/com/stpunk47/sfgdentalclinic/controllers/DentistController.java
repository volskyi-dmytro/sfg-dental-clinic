package com.stpunk47.sfgdentalclinic.controllers;

import com.stpunk47.sfgdentalclinic.model.Dentist;
import com.stpunk47.sfgdentalclinic.services.DentistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Controller
public class DentistController {

    private final DentistService dentistService;

    public DentistController(DentistService dentistService) {
        this.dentistService = dentistService;
    }

    @RequestMapping({"/dentists","/dentists/index","dentists/index.html"})
    public String listDentists(Model model){
        model.addAttribute("dentists", dentistService.findAll());

        return "dentists/index";
    }

    @GetMapping("/api/dentists")
    public @ResponseBody Set<Dentist> getDentistsJson(){

        return dentistService.findAll();
    }

}
