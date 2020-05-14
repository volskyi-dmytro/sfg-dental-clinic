package com.stpunk47.sfgdentalclinic.repositories;

import com.stpunk47.sfgdentalclinic.model.Company;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompanyRepository extends CrudRepository<Company, Long> {
    Company findByLastName(String lastName);

    List<Company> findAllByLastNameLike(String lastName);

}
