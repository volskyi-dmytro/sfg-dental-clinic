package com.stpunk47.sfgdentalclinic.services.map;

import com.stpunk47.sfgdentalclinic.model.Worker;
import com.stpunk47.sfgdentalclinic.services.WorkerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class WorkerServiceMap extends AbsrtactMapService<Worker, Long> implements WorkerService {
    @Override
    public Set<Worker> findAll() {
        return super.findAll();
    }

    @Override
    public Worker findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Worker save(Worker object) {
        return super.save(object);
    }

    @Override
    public void delete(Worker object) {
        super.delete(object);
    }

    @Override
    public void deleteByID(Long id) {
        super.deleteById(id);
    }
}
