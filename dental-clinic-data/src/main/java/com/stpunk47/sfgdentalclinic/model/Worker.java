package com.stpunk47.sfgdentalclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "workers")
public class Worker extends BaseEntity{

    @Builder
    public Worker (Long id,
                   String firstName,
                   String lastName,
                   Department department,
                   Company company,
                   LocalDate birthday,
                   Set<Visit> visits){
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.company = company;
        this.birthday = birthday;
        this.visits = visits;

    }



    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(name="birth_date")
    private LocalDate birthday;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "worker")
    private Set<Visit> visits = new HashSet<>();

}
