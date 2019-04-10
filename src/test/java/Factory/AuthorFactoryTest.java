package Factory;

import model.Author;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AuthorFactoryTest {

    private Author author;
    @Before
    public void setUp() throws Exception {
        author = AuthorFactory.createAuthor(1447,"John","Smith","18 Waxberry","0117149555");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void createAuthor() {
        Assert.assertEquals(author.getAddress(),author.getAddress());
    }
}