package za.ac.cput.domain.controller.book;

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
import za.ac.cput.domain.domain.authors.Author;
import za.ac.cput.domain.domain.book.Article;
import za.ac.cput.domain.domain.book.Book;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class BookControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;
    private String baseURL = "http://localgost:8080/domain";
    private Book book;
    @Before
    public void setUp() throws Exception {
        book = ArticleFactory.firstArticle("Lost City",2015);
    }
    @Test(expected = IllegalStateException.class)
    @Ignore
    public void create() {

        ResponseEntity<Book> postResponse = testRestTemplate.postForEntity(baseURL + "/create", book, Book.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

    }

    @Test
    public void read() {
        book = testRestTemplate.getForObject(baseURL + "/book/", Book.class);

        assertNotNull(book);
    }

    @Test
    public void update() {

        book = testRestTemplate.getForObject(baseURL + "/book/" + book.getIsbnNum(), Book.class);

        testRestTemplate.put(baseURL + "/book/" + book.getIsbnNum(), book);
        Book updatedBook = testRestTemplate.getForObject(baseURL + "/book/" +book.getIsbnNum(), Book.class);
        assertNotNull(updatedBook);
    }

    @Test
    public void delete() {

        book = testRestTemplate.getForObject(baseURL + "/book/" + book.getIsbnNum(), Book.class);
        assertNotNull(book);
        testRestTemplate.delete(baseURL + "/book/" + book.getIsbnNum());
        try {
            book = testRestTemplate.getForObject(baseURL + "/book/" + book.getIsbnNum(), Book.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}