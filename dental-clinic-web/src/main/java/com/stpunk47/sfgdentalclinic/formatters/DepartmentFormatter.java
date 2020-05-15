package com.stpunk47.sfgdentalclinic.formatters;

import com.stpunk47.sfgdentalclinic.model.Department;
import com.stpunk47.sfgdentalclinic.services.DepartmentService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

@Component
public class DepartmentFormatter implements Formatter<Department> {

    private final DepartmentService departmentService;

    public DepartmentFormatter(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public String print(Department department, Locale locale){
        return department.getName();
    }

    @Override
    public Department parse(String text, Locale locale) throws ParseException{
        Collection<Department> findDepartments = departmentService.findAll();
        for (Department department : findDepartments){
            if(department.getName().equals(text)){
                return department;
            }
        }
        throw new ParseException("Department not found" + text, 0);
    }
}
