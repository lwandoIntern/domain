package za.ac.cput.domain.controller.system_access.registration;

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
import za.ac.cput.domain.Factory.system_access.LoginFactory;
import za.ac.cput.domain.Factory.system_access.RegisterFactory;
import za.ac.cput.domain.domain.sysemAccess.Login;
import za.ac.cput.domain.domain.sysemAccess.Register;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class RegisterControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;
    private String baseURL = "http://localgost:8080/domain";
    private Register register;
    @Before
    public void setUp() throws Exception {
        register = RegisterFactory.newRegister("John","Smith");
    }
    @Test(expected = IllegalStateException.class)
    @Ignore
    public void create() {

        ResponseEntity<Register> postResponse = testRestTemplate.postForEntity(baseURL + "/create", register, Register.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

    }

    @Test
    public void read() {
        register = testRestTemplate.getForObject(baseURL + "/register/", Register.class);

        assertNotNull(register);
    }

    @Test
    public void update() {

        register = testRestTemplate.getForObject(baseURL + "/register/" + register.getRegNum(), Register.class);

        testRestTemplate.put(baseURL + "/register/" + register.getRegNum(), register);
        Register updatedRegister = testRestTemplate.getForObject(baseURL + "/register/" + register.getRegNum(), Register.class);
        assertNotNull(updatedRegister);
    }

    @Test
    public void delete() {

        register = testRestTemplate.getForObject(baseURL + "/register/" + register.getRegNum(), Register.class);
        assertNotNull(register);
        testRestTemplate.delete(baseURL + "/register/" + register.getRegNum());
        try {
            register = testRestTemplate.getForObject(baseURL + "/register/" + register.getRegNum(), Register.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}