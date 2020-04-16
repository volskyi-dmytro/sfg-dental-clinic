package com.stpunk47.sfgdentalclinic.services.springdatajpa;

import com.stpunk47.sfgdentalclinic.model.Worker;
import com.stpunk47.sfgdentalclinic.repositories.WorkerRepository;
import com.stpunk47.sfgdentalclinic.services.WorkerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class WorkerSDJpaService implements WorkerService {

    private final WorkerRepository workerRepository;

    public WorkerSDJpaService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @Override
    public Set<Worker> findAll() {
        Set<Worker> workers = new HashSet<>();
        workerRepository.findAll().forEach(workers::add);
        return workers;
    }

    @Override
    public Worker findById(Long aLong) {
        return workerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Worker save(Worker object) {
        return workerRepository.save(object);
    }

    @Override
    public void delete(Worker object) {
        workerRepository.delete(object);

    }

    @Override
    public void deleteByID(Long aLong) {
        workerRepository.deleteById(aLong);

    }
}
