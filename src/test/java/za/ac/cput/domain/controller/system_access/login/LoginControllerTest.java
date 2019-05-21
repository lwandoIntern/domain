package za.ac.cput.domain.controller.system_access.login;

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
import za.ac.cput.domain.Factory.member.StudentMemberFactory;
import za.ac.cput.domain.Factory.system_access.LoginFactory;
import za.ac.cput.domain.domain.member.Member;
import za.ac.cput.domain.domain.sysemAccess.Login;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class LoginControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;
    private String baseURL = "http://localgost:8080/domain";
    private Login login;
    @Before
    public void setUp() throws Exception {
        login = LoginFactory.createLogin("john","#john$$");
    }
    @Test(expected = IllegalStateException.class)
    @Ignore
    public void create() {

        ResponseEntity<Login> postResponse = testRestTemplate.postForEntity(baseURL + "/create", login, Login.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

    }

    @Test
    public void read() {
        login = testRestTemplate.getForObject(baseURL + "/login/", Login.class);

        assertNotNull(login);
    }

    @Test
    public void update() {

        login = testRestTemplate.getForObject(baseURL + "/login/" + login.getUsername(), Login.class);

        testRestTemplate.put(baseURL + "/login/" + login.getUsername(), login);
        Login updatedLogin = testRestTemplate.getForObject(baseURL + "/login/" + login.getUsername(), Login.class);
        assertNotNull(updatedLogin);
    }

    @Test
    public void delete() {

        login = testRestTemplate.getForObject(baseURL + "/login/" + login.getUsername(), Login.class);
        assertNotNull(login);
        testRestTemplate.delete(baseURL + "/login/" + login.getUsername());
        try {
            login = testRestTemplate.getForObject(baseURL + "/login/" + login.getUsername(), Login.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}