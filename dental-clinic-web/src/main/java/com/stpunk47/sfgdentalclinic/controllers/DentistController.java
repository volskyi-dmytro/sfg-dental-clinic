package com.stpunk47.sfgdentalclinic.controllers;

import com.stpunk47.sfgdentalclinic.services.DentistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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


}
