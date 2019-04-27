package za.ac.cput.domain.repository.employ_repo.impl;

import employees.Employee;
import za.ac.cput.domain.repository.employ_repo.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

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
