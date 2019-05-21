package za.ac.cput.domain.controller.employee;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import za.ac.cput.domain.Factory.books.ArticleFactory;
import za.ac.cput.domain.Factory.employee.AdminFactory;
import za.ac.cput.domain.Factory.employee.LibrarianFactory;
import za.ac.cput.domain.Factory.employee.ManagerFactory;
import za.ac.cput.domain.domain.book.Book;
import za.ac.cput.domain.domain.employee.Employee;

import static org.junit.Assert.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class EmployeeControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;
    private String baseURL = "http://localgost:8080/domain";
    private Employee employee;
    @Before
    public void setUp() throws Exception {
        employee = LibrarianFactory.createAssistant("Ass","istant","Librarian");
    }
    @Test(expected = IllegalStateException.class)
    @Ignore
    public void create() {

        ResponseEntity<Employee> postResponse = testRestTemplate.postForEntity(baseURL + "/create", employee, Employee.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

    }

    @Test
    public void read() {
        employee = testRestTemplate.getForObject(baseURL + "/employee/", Employee.class);

        assertNotNull(employee);
    }

    @Test
    public void update() {

        employee = testRestTemplate.getForObject(baseURL + "/employee/" + employee.getEmployeeId(), Employee.class);

        testRestTemplate.put(baseURL + "/employee/" + employee.getEmployeeId(), employee);
        Employee updatedEmployee = testRestTemplate.getForObject(baseURL + "/employee/" + employee.getEmployeeId(), Employee.class);
        assertNotNull(updatedEmployee);
    }

    @Test
    public void delete() {

        employee = testRestTemplate.getForObject(baseURL + "/employee/" + employee.getEmployeeId(), Employee.class);
        assertNotNull(employee);
        testRestTemplate.delete(baseURL + "/employee/" + employee.getEmployeeId());
        try {
            employee = testRestTemplate.getForObject(baseURL + "/employee/" + employee.getEmployeeId(), Employee.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}