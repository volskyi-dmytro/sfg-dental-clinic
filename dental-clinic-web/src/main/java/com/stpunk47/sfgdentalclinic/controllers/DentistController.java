package com.stpunk47.sfgdentalclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DentistController {

    @RequestMapping({"/dentists","/dentists/index","dentists/index.html"})
    public String listDentists(){
        return "dentists/index";
    }
}
