package com.stpunk47.sfgdentalclinic.services;


import com.stpunk47.sfgdentalclinic.model.Dentist;

import java.util.Set;

public interface DentistService {

    Dentist findById(Long id);

    Dentist save(Dentist dentist);

    Set<Dentist> findAll();
}
