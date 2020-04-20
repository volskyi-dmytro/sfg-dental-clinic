package com.stpunk47.sfgdentalclinic.services.map;

import com.stpunk47.sfgdentalclinic.model.Visit;
import com.stpunk47.sfgdentalclinic.services.VisitService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VisitServiceMap extends AbsrtactMapService<Visit, Long> implements VisitService {

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit visit) {

        if(visit.getWorker() == null || visit.getWorker().getCompany() == null || visit.getWorker().getId() ==null
        || visit.getWorker().getCompany().getId() == null){
            throw new RuntimeException("Invalid Visit");
        }

        return super.save(visit);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);

    }

    @Override
    public void deleteByID(Long aLong) {
        super.deleteById(aLong);
    }
}
