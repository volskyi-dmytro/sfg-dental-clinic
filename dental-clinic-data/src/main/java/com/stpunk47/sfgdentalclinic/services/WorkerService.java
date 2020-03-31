package com.stpunk47.sfgdentalclinic.services;


import com.stpunk47.sfgdentalclinic.model.Worker;

import java.util.Set;

public interface WorkerService {

    Worker findById(Long id);

    Worker save(Worker worker);

    Set<Worker> findAll();
}
