package com.stpunk47.sfgdentalclinic.services.springdatajpa;

import com.stpunk47.sfgdentalclinic.model.Department;
import com.stpunk47.sfgdentalclinic.repositories.DepartmentRepository;
import com.stpunk47.sfgdentalclinic.services.DepartmentService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class DepartmentSDJpaService implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentSDJpaService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Set<Department> findAll() {
        Set<Department> departments = new HashSet<>();
        departmentRepository.findAll().forEach(departments::add);
        return departments;
    }

    @Override
    public Department findById(Long aLong) {
        return departmentRepository.findById(aLong).orElse(null);
    }

    @Override
    public Department save(Department object) {
        return departmentRepository.save(object);
    }

    @Override
    public void delete(Department object) {
        departmentRepository.delete(object);
    }

    @Override
    public void deleteByID(Long aLong) {
        departmentRepository.deleteById(aLong);
    }
}
