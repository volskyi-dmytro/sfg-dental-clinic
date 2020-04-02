package com.stpunk47.sfgdentalclinic.services.map;

import com.stpunk47.sfgdentalclinic.model.Company;
import com.stpunk47.sfgdentalclinic.services.CrudService;

import java.util.Set;

public class CompanyServiceMap extends AbsrtactMapService<Company, Long> implements CrudService<Company, Long> {

    @Override
    public Set<Company> findAll() {
        return super.findAll();
    }

    @Override
    public Company findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Company save(Company object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void delete(Company object) {
        super.delete(object);
    }

    @Override
    public void deleteByID(Long id) {
        this.deleteById(id);

    }
}
