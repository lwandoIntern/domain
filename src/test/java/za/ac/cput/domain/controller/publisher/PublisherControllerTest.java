package za.ac.cput.domain.controller.publisher;

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
import za.ac.cput.domain.Factory.publisher.PublisherFactory;
import za.ac.cput.domain.domain.member.Member;
import za.ac.cput.domain.domain.publisher.Publisher;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class PublisherControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;
    private String baseURL = "http://localgost:8080/domain";
    private Publisher publisher;
    @Before
    public void setUp() throws Exception {
        publisher = PublisherFactory.createPubHouse("Oxford","0210211120",8000);
    }
    @Test(expected = IllegalStateException.class)
    @Ignore
    public void create() {

        ResponseEntity<Publisher> postResponse = testRestTemplate.postForEntity(baseURL + "/create", publisher, Publisher.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

    }

    @Test
    public void read() {
        publisher = testRestTemplate.getForObject(baseURL + "/publisher/", Publisher.class);

        assertNotNull(publisher);
    }

    @Test
    public void update() {

        publisher = testRestTemplate.getForObject(baseURL + "/publisher/" + publisher.getPublishId(), Publisher.class);

        testRestTemplate.put(baseURL + "/publisher/" + publisher.getPublishId(), publisher);
        Publisher updatedPublisher = testRestTemplate.getForObject(baseURL + "/publisher/" + publisher.getPublishId(), Publisher.class);
        assertNotNull(updatedPublisher);
    }

    @Test
    public void delete() {

        publisher = testRestTemplate.getForObject(baseURL + "/publisher/" + publisher.getPublishId(), Publisher.class);
        assertNotNull(publisher);
        testRestTemplate.delete(baseURL + "/publisher/" + publisher.getPublishId());
        try {
            publisher = testRestTemplate.getForObject(baseURL + "/publisher/" + publisher.getPublishId(), Publisher.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}