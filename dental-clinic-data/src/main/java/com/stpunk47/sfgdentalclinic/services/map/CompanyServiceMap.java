package com.stpunk47.sfgdentalclinic.services.map;

import com.stpunk47.sfgdentalclinic.model.Company;
import com.stpunk47.sfgdentalclinic.model.Worker;
import com.stpunk47.sfgdentalclinic.services.CompanyService;
import com.stpunk47.sfgdentalclinic.services.DepartmentService;
import com.stpunk47.sfgdentalclinic.services.WorkerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class CompanyServiceMap extends AbsrtactMapService<Company, Long> implements CompanyService {

    private final DepartmentService departmentService;
    private final WorkerService workerService;


    public CompanyServiceMap(DepartmentService departmentService, WorkerService workerService) {
        this.departmentService = departmentService;
        this.workerService = workerService;
    }

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

        if(object != null) {
            if(object.getWorkers() != null){
                object.getWorkers().forEach(worker -> {
                    if(worker.getDepartment() != null){
                        if(worker.getDepartment().getId()== null){
                            worker.setDepartment(departmentService.save(worker.getDepartment()));
                        }
                    } else {
                        throw new RuntimeException("Department is required");
                    }
                    if(worker.getId()==null){
                        Worker savedWorker = workerService.save(worker);
                        worker.setId(savedWorker.getId());
                    }
                });
            }
            return super.save(object);
        } else{
            return null;
        }


    }

    @Override
    public void delete(Company object) {
        super.delete(object);
    }

    @Override
    public void deleteByID(Long id) {
        this.deleteById(id);

    }

    @Override
    public Company findByLastName(String lastName) {
        return null;
    }
}
