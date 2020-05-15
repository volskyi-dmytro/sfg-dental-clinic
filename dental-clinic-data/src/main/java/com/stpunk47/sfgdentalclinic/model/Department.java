package com.stpunk47.sfgdentalclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "departments")
public class Department extends BaseEntity{

    @Builder
    public Department(Long id, String name){
        super(id);
        this.name = name;
    }


    @Column(name="name")
    private String name;

    @Override
    public String toString() {
        return name;
    }
}
