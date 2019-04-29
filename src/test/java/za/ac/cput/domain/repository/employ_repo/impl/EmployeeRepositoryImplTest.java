package za.ac.cput.domain.repository.employ_repo.impl;

import za.ac.cput.domain.domain.employees.Employee;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.domain.Factory.staff.LibrarianFactory;
import za.ac.cput.domain.repository.employ_repo.EmployeeRepository;

import static org.junit.Assert.*;

public class EmployeeRepositoryImplTest {

    private EmployeeRepository repository;
    private Employee employee;
    @Before
    public void setUp() throws Exception {
        repository = EmployeeRepositoryImpl.getRepository();
        employee = LibrarianFactory.createLibrarian("j4","x","y","z","a","b",7554,"f",false);
    }

    @Test
    public void create() {
        assertEquals(repository.create(employee),repository.create(employee));
    }

    @Test
    public void read() {
        assertEquals(repository.read(employee),repository.read(employee));
    }

    @Test
    public void update() {
        assertEquals(repository.update(employee),repository.update(employee));
    }

    @Test
    public void delete() {
        repository.delete(employee.getEmployeeId());
    }
}