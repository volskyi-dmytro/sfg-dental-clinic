package com.stpunk47.sfgdentalclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "departments")
public class Department extends BaseEntity{

    @Column(name="name")
    private String name;

    @Override
    public String toString() {
        return name;
    }
}
