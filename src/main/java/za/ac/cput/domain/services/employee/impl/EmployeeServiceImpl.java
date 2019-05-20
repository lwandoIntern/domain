package za.ac.cput.domain.services.employee.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.domain.employee.Employee;
import za.ac.cput.domain.repository.employee.impl.EmployeeRepositoryImpl;
import za.ac.cput.domain.services.employee.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepositoryImpl repository;

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
