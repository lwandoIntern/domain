package za.ac.cput.domain.services.employee.impl;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.Factory.employee.AdminFactory;
import za.ac.cput.domain.domain.employee.Employee;

import static org.junit.Assert.*;

public class EmployeeServiceImplTest {

    @Autowired
    private EmployeeServiceImpl service;
    private Employee employee;
    @Before
    public void setUp() throws Exception {
        employee = AdminFactory.createAdmin("nceba","goniwe","xxx","ttt",1111,"aaa","sss","ppp","its",
                false,false);
    }

    @Test(expected = NullPointerException.class)
    public void create() {
        assertNull(service.create(employee));
    }

    @Test
    public void update() {
        assertEquals(service.update(employee),service.update(employee));
    }

    @Test
    public void delete() {
        service.delete(employee.getEmployeeId());
    }

    @Test
    public void read() {
        assertEquals(service.read(employee),service.read(employee));
    }
}