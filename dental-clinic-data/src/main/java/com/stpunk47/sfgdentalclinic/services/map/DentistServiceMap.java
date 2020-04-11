package com.stpunk47.sfgdentalclinic.services.map;

import com.stpunk47.sfgdentalclinic.model.Dentist;
import com.stpunk47.sfgdentalclinic.model.Specialty;
import com.stpunk47.sfgdentalclinic.services.DentistService;
import com.stpunk47.sfgdentalclinic.services.SpecialtyService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class DentistServiceMap extends AbsrtactMapService<Dentist, Long> implements DentistService {

    private final SpecialtyService specialtyService;

    public DentistServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }


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
        if(object.getSpecialties().size() >0){
            object.getSpecialties().forEach(specialty -> {
               if(specialty.getId() == null){
                   Specialty savedSpecialty = specialtyService.save(specialty);
                   specialty.setId(savedSpecialty.getId());
               }
            });
        }

        return super.save(object);
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
