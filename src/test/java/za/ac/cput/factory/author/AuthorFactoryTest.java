package za.ac.cput.factory.author;

import org.junit.Before;
import org.junit.Test;
import za.ac.cput.domain.author.Author;

import static org.junit.Assert.*;

public class AuthorFactoryTest {

    private Author author;
    @Before
    public void setUp() throws Exception {
        author = AuthorFactory.createAuthor("2016maila","Nceba","Goniwe",12);
    }

    @Test
    public void createAuthor() {
        System.out.println(author.toString());
        assertNotNull(author);
    }
}