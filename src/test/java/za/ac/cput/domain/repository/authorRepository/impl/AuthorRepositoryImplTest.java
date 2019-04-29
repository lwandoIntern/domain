package za.ac.cput.domain.repository.authorRepository.impl;

import za.ac.cput.domain.domain.authors.Author;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.domain.Factory.author.AuthorFactory;
import za.ac.cput.domain.repository.authorRepository.AuthorRepository;

import static org.junit.Assert.*;

public class AuthorRepositoryImplTest {

    private AuthorRepository authorRepository;
    private Author author;
    @Before
    public void setUp() throws Exception {
        authorRepository = AuthorRepositoryImpl.getAuthorRepository();
        author = AuthorFactory.createAuthor("","a","12","021",7442,"MIL",
                "CPT","WC",2);
    }

    @Test
    public void getAll() {
        assertEquals(authorRepository.getAll(),authorRepository.getAll());
    }

    @Test
    public void create() {
        assertEquals(authorRepository.create(author),authorRepository.create(author));
    }

    @Test
    public void read() {
        assertEquals(authorRepository.read(author),authorRepository.read(author));
    }

    @Test
    public void update() {
        assertEquals(authorRepository.update(author),authorRepository.update(author));
    }

    @Test
    public void delete() {
        authorRepository.delete(author.getAuthId());
    }
}