package za.ac.cput.domain.controller.system_access.forgot_password;

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
import za.ac.cput.domain.Factory.system_access.ForgotPasswordFactory;
import za.ac.cput.domain.domain.member.Member;
import za.ac.cput.domain.domain.sysemAccess.ForgotPassword;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class ForgotPasswordControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;
    private String baseURL = "http://localgost:8080/domain";
    private ForgotPassword forgotPassword;
    @Before
    public void setUp() throws Exception {
        forgotPassword = ForgotPasswordFactory.createForgotPassword("mm5454");
    }
    @Test(expected = IllegalStateException.class)
    @Ignore
    public void create() {

        ResponseEntity<ForgotPassword> postResponse = testRestTemplate.postForEntity(baseURL + "/create", forgotPassword, ForgotPassword.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

    }

    @Test
    public void read() {
        forgotPassword = testRestTemplate.getForObject(baseURL + "/forgot_pass/", ForgotPassword.class);

        assertNotNull(forgotPassword);
    }

    @Test
    public void update() {

        forgotPassword = testRestTemplate.getForObject(baseURL + "/forgot_pass/" + forgotPassword, ForgotPassword.class);

        testRestTemplate.put(baseURL + "/forgot_pass/" + forgotPassword.getPassword(), forgotPassword);
        ForgotPassword updatedForgotPass = testRestTemplate.getForObject(baseURL + "/forgot_pass/" + forgotPassword.getPassword(), ForgotPassword.class);
        assertNotNull(updatedForgotPass);
    }

    @Test
    public void delete() {

        forgotPassword = testRestTemplate.getForObject(baseURL + "/forgot_pass/" + forgotPassword.getPassword(), ForgotPassword.class);
        assertNotNull(forgotPassword);
        testRestTemplate.delete(baseURL + "/forgot_pass/" + forgotPassword);
        try {
            forgotPassword = testRestTemplate.getForObject(baseURL + "/forgot_pass/" + forgotPassword.getPassword(), ForgotPassword.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}