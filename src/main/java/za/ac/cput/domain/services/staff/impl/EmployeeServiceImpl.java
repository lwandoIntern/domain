package za.ac.cput.domain.services.staff.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.domain.employees.Employee;
import za.ac.cput.domain.repository.employ_repo.impl.EmployeeRepositoryImpl;
import za.ac.cput.domain.services.staff.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static EmployeeServiceImpl service = null;
    private EmployeeRepositoryImpl repository;

    private EmployeeServiceImpl(){
        this.repository = EmployeeRepositoryImpl.getRepository();
    }
    public static EmployeeServiceImpl getService(){
        if (service == null)service = new EmployeeServiceImpl();
        return service;
    }
    @Override
    public Employee create(Employee employee) {
        return this.repository.create(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return this.repository.update(employee);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Employee read(Employee employee) {
        return this.repository.read(employee);
    }
}
