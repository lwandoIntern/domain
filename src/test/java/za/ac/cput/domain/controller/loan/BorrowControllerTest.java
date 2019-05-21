package za.ac.cput.domain.controller.loan;

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
import za.ac.cput.domain.Factory.employee.LibrarianFactory;
import za.ac.cput.domain.Factory.loan.BorrowFactory;
import za.ac.cput.domain.Factory.member.StudentMemberFactory;
import za.ac.cput.domain.domain.employee.Employee;
import za.ac.cput.domain.domain.loan.Borrow;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class BorrowControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;
    private String baseURL = "http://localgost:8080/domain";
    private Borrow borrow;
    @Before
    public void setUp() throws Exception {
        borrow = BorrowFactory.createLoan(ArticleFactory.firstArticle("Lost City",2004), StudentMemberFactory.createStudentMember(5));
    }
    @Test(expected = IllegalStateException.class)
    @Ignore
    public void create() {

        ResponseEntity<Borrow> postResponse = testRestTemplate.postForEntity(baseURL + "/create", borrow, Borrow.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

    }

    @Test
    public void read() {
        borrow = testRestTemplate.getForObject(baseURL + "/borrow/", Borrow.class);

        assertNotNull(borrow);
    }

    @Test
    public void update() {

        borrow = testRestTemplate.getForObject(baseURL + "/borrow/" + borrow.getLoanId(), Borrow.class);

        testRestTemplate.put(baseURL + "/borrow/" + borrow.getLoanId(), borrow);
        Borrow updatedBorrow = testRestTemplate.getForObject(baseURL + "/borrow/" + borrow.getLoanId(), Borrow.class);
        assertNotNull(updatedBorrow);
    }

    @Test
    public void delete() {

        borrow = testRestTemplate.getForObject(baseURL + "/borrow/" + borrow.getLoanId(), Borrow.class);
        assertNotNull(borrow);
        testRestTemplate.delete(baseURL + "/borrow/" + borrow.getLoanId());
        try {
            borrow = testRestTemplate.getForObject(baseURL + "/borrow/" + borrow.getLoanId(), Borrow.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}