package com.stpunk47.sfgdentalclinic.services.map;

import com.stpunk47.sfgdentalclinic.model.Department;
import com.stpunk47.sfgdentalclinic.services.DepartmentService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class DepartmentMapService extends AbsrtactMapService<Department, Long> implements DepartmentService {

    @Override
    public Set<Department> findAll() {
        return super.findAll();
    }

    @Override
    public Department findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Department save(Department object) {
        return super.save(object);
    }

    @Override
    public void delete(Department object) {
        super.delete(object);

    }

    @Override
    public void deleteByID(Long id) {
        super.deleteById(id);
    }
}
