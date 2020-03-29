package com.stpunk47.sfgdentalclinic.model;

import java.time.LocalDate;

public class Worker {

    private Department department;
    private Company company;
    private LocalDate birthday;

    public Worker(Department department, Company company, LocalDate birthday) {
        this.department = department;
        this.company = company;
        this.birthday = birthday;
    }
}
