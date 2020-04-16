package com.stpunk47.sfgdentalclinic.services.springdatajpa;

import com.stpunk47.sfgdentalclinic.model.Dentist;
import com.stpunk47.sfgdentalclinic.repositories.DentistRepository;
import com.stpunk47.sfgdentalclinic.services.DentistService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class DentistSDJpaService implements DentistService {

    private final DentistRepository dentistRepository;

    public DentistSDJpaService(DentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }

    @Override
    public Set<Dentist> findAll() {
        Set<Dentist> dentists = new HashSet<>();
        dentistRepository.findAll().forEach(dentists::add);
        return dentists;
    }

    @Override
    public Dentist findById(Long aLong) {
        return dentistRepository.findById(aLong).orElse(null);
    }

    @Override
    public Dentist save(Dentist object) {
        return dentistRepository.save(object);
    }

    @Override
    public void delete(Dentist object) {
        dentistRepository.delete(object);
    }

    @Override
    public void deleteByID(Long aLong) {
        dentistRepository.deleteById(aLong);
    }
}
