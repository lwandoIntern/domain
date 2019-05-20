package za.ac.cput.domain.repository.employee.impl;

import org.springframework.stereotype.Repository;
import za.ac.cput.domain.domain.employee.Employee;
import za.ac.cput.domain.repository.employee.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private static EmployeeRepositoryImpl repository = null;
    List<Employee> employees;

    private EmployeeRepositoryImpl(){
        this.employees = new ArrayList<>();
    }

    public static EmployeeRepositoryImpl getRepository() {
        if(repository == null)repository = new EmployeeRepositoryImpl();
        return repository;
    }

    @Override
    public Employee create(Employee employee) {
        repository.employees.add(employee);
        int x = employees.indexOf(employee);
        return employees.get(x);
    }

    @Override
    public Employee read(Employee employee) {
        int x = employees.indexOf(employee);
        return repository.employees.get(x);
    }

    @Override
    public Employee update(Employee employee) {
        repository.employees.add(employee);
        int x = employees.indexOf(employee);
        return repository.employees.get(x);
    }

    @Override
    public void delete(String s) {
        repository.employees.remove(s);
    }
}
