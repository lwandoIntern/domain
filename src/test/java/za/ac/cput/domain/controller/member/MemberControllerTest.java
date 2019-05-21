package za.ac.cput.domain.controller.member;

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
import za.ac.cput.domain.Factory.loan.BorrowFactory;
import za.ac.cput.domain.Factory.member.StudentMemberFactory;
import za.ac.cput.domain.domain.loan.Borrow;
import za.ac.cput.domain.domain.member.Member;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class MemberControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;
    private String baseURL = "http://localgost:8080/domain";
    private Member member;
    @Before
    public void setUp() throws Exception {
        member = StudentMemberFactory.createStudentMember(4);
    }
    @Test(expected = IllegalStateException.class)
    @Ignore
    public void create() {

        ResponseEntity<Member> postResponse = testRestTemplate.postForEntity(baseURL + "/create", member, Member.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

    }

    @Test
    public void read() {
        member = testRestTemplate.getForObject(baseURL + "/member/", Member.class);

        assertNotNull(member);
    }

    @Test
    public void update() {

        member = testRestTemplate.getForObject(baseURL + "/member/" + member.getMemberId(), Member.class);

        testRestTemplate.put(baseURL + "/member/" + member.getMemberId(), member);
        Member updatedMember = testRestTemplate.getForObject(baseURL + "/member/" + member.getMemberId(), Member.class);
        assertNotNull(updatedMember);
    }

    @Test
    public void delete() {

        member = testRestTemplate.getForObject(baseURL + "/member/" + member.getMemberId(), Member.class);
        assertNotNull(member);
        testRestTemplate.delete(baseURL + "/member/" + member.getMemberId());
        try {
            member = testRestTemplate.getForObject(baseURL + "/member/" + member.getMemberId(), Member.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}