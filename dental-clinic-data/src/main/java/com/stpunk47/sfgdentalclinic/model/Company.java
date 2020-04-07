package com.stpunk47.sfgdentalclinic.model;

import java.util.Set;

public class Company extends Person {

    private Set<Worker> workers;

    public Set<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(Set<Worker> workers) {
        this.workers = workers;
    }
}
