package za.ac.cput.domain.Factory;

import za.ac.cput.domain.Factory.author.AuthorFactory;
import za.ac.cput.domain.domain.authors.Author;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.domain.domain.value_objects.Address;
import za.ac.cput.domain.domain.value_objects.Contacts;
import za.ac.cput.domain.domain.value_objects.Names;

public class AuthorFactoryTest {

    private Author author;
    @Before
    public void setUp() throws Exception {
        author = AuthorFactory.createAuthor("123",new Names("John","Smith"),new Contacts("",""),
                new Address(1234,"a12","Z"),12);
    }

    @Test
    public void createAuthor() {
        Assert.assertNotNull(author);
    }
}