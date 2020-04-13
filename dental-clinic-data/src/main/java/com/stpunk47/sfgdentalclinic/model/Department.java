package com.stpunk47.sfgdentalclinic.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "departments")
public class Department extends BaseEntity{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
