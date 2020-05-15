package com.stpunk47.sfgdentalclinic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor


@Entity
@Table(name = "companies")
public class Company extends Person {

    @Builder
    public Company(Long id, String firstName, String lastName, String address, String city, String phone,
                   Set<Worker> workers) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.phone = phone;

        if(workers != null) {
            this.workers = workers;
        }
    }

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "phone")
    private String phone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private Set<Worker> workers = new HashSet<>();

    public Worker getWorker(String firstName, String lastName){
        return getWorker(firstName, lastName,false);
    }

    public Worker getWorker(String firstName, String lastName, boolean ignoreNew){
        firstName = firstName.toLowerCase();
        lastName = lastName.toLowerCase();
        for (Worker worker: workers){
            if(!ignoreNew || !worker.isNew()){
                String compName = worker.getFirstName();
                String comp2Name = worker.getLastName();
                if(compName.equals(firstName) && comp2Name.equals(lastName)){
                    return worker;
                }
            }
        }
        return null;
    }

}
