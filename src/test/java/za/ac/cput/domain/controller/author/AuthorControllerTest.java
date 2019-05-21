package za.ac.cput.domain.controller.author;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import za.ac.cput.domain.Factory.author.AuthorFactory;
import za.ac.cput.domain.domain.authors.Author;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class AuthorControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;
    private String baseURL = "http://localgost:8080/domain";
    private Author author;

    @Before
    public void setUp()throws Exception{
        author = AuthorFactory.amateurAuthor("Vido","Goniwe");
    }
    @Test(expected = IllegalStateException.class)
    public void create() {

        ResponseEntity<Author> postResponse = testRestTemplate.postForEntity(baseURL + "/create", author, Author.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

    }

    @Test
    public void read() {
         author = testRestTemplate.getForObject(baseURL + "/author/", Author.class);

        assertNotNull(author);
    }

    @Test
    public void update() {

         author = testRestTemplate.getForObject(baseURL + "/author/" + author.getAuthId(), Author.class);

        testRestTemplate.put(baseURL + "/author/" + author.getAuthId(), author);
        Author updatedAuthor = testRestTemplate.getForObject(baseURL + "/author/" + author.getAuthId(), Author.class);
        assertNotNull(updatedAuthor);
    }

    @Test
    public void delete() {

        author = testRestTemplate.getForObject(baseURL + "/author/" + author.getAuthId(), Author.class);
        assertNotNull(author);
        testRestTemplate.delete(baseURL + "/author/" + author.getAuthId());
        try {
            author = testRestTemplate.getForObject(baseURL + "/author/" + author.getAuthId(), Author.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}