package za.ac.cput.domain.Factory;

import za.ac.cput.domain.Factory.author.AuthorFactory;
import za.ac.cput.domain.domain.authors.Author;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AuthorFactoryTest {

    private Author author;
    @Before
    public void setUp() throws Exception {
        author = AuthorFactory.createAuthor("James","Bond",null,null,7441,"Mil","CPT","WC",
                12);
    }

    @Test
    public void createAuthor() {
        Assert.assertNotNull(author);
    }
}