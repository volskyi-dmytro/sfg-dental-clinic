package com.stpunk47.sfgdentalclinic.model;

import java.util.HashSet;
import java.util.Set;

public class Dentist extends Person {

    private Set<Specialty> specialties = new HashSet<>();

    public Set<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Set<Specialty> specialties) {
        this.specialties = specialties;
    }
}
