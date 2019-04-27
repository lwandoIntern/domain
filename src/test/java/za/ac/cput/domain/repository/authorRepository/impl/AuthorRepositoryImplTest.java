package za.ac.cput.domain.repository.authorRepository.impl;

import org.junit.Before;
import org.junit.Test;
import za.ac.cput.domain.repository.authorRepository.AuthorRepository;

import static org.junit.Assert.*;

public class AuthorRepositoryImplTest {

    private AuthorRepository authorRepository;
    @Before
    public void setUp() throws Exception {
        authorRepository = AuthorRepositoryImpl.getAuthorRepository();
    }

    @Test
    public void getAll() {
        assertEquals(authorRepository.getAll(),authorRepository.getAll());
    }

    @Test
    public void create() {

    }

    @Test
    public void read() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}