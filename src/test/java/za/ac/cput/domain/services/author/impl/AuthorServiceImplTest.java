package za.ac.cput.domain.services.author.impl;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.Factory.author.AuthorFactory;
import za.ac.cput.domain.domain.authors.Author;

import static org.junit.Assert.*;

public class AuthorServiceImplTest {

    @Autowired
    private AuthorServiceImpl service;
    private Author author;
    @Before
    public void setUp() throws Exception {
        author = AuthorFactory.createAuthor("Nceba","Goniwe","0740740918","0217149555",7441,"MLT",
                "CPT","WC",5);
    }

    @Test
    public void getAllAuthors() {
        assertEquals(service.getAllAuthors(),service.getAllAuthors());
    }

    @Test
    public void create() {
        assertEquals(service.create(author),service.create(author));
    }

    @Test
    public void update() {
        assertEquals(service.update(author),service.update(author));
    }

    @Test
    public void delete() {
        service.delete(author.getAuthId());
    }

    @Test
    public void read() {
    }
}