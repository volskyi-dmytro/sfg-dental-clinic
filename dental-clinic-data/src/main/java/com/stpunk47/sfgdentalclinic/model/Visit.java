package com.stpunk47.sfgdentalclinic.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table("visits")
public class Visit extends BaseEntity {

    @Column("date")
    private LocalDate date;

    @Column("description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "worker_id")
    private Worker worker;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }
}
