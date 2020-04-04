package com.stpunk47.sfgdentalclinic.services.map;

import com.stpunk47.sfgdentalclinic.model.Dentist;
import com.stpunk47.sfgdentalclinic.services.DentistService;

import java.util.Set;

public class DentistServiceMap extends AbsrtactMapService<Dentist, Long> implements DentistService {
    @Override
    public Set<Dentist> findAll() {
        return super.findAll();
    }

    @Override
    public Dentist findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Dentist save(Dentist object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void delete(Dentist object) {
        super.delete(object);
    }

    @Override
    public void deleteByID(Long id) {
        super.deleteById(id);
    }
}
