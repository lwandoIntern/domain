package za.ac.cput.domain.repository.impl;

import authors.Author;
import za.ac.cput.domain.repository.AuthorRepository;

import java.util.HashSet;
import java.util.Set;

public class AuthorRepositoryImpl implements AuthorRepository {
    private static AuthorRepositoryImpl repository = null;
    private Set<Author> authorSet;

    private AuthorRepositoryImpl(){
        this.authorSet = new HashSet<>();
    }

    public static AuthorRepository getAuthorRepository(){
        if (repository == null) repository = new AuthorRepositoryImpl();
        return repository;
    }


    @Override
    public Set<Author> getAll() {
        return null;
    }

    @Override
    public Author create(Author author) {
        this.authorSet.add(author);
        return author;
    }

    @Override
    public Author read(Author author) {
        return null;
    }

    @Override
    public Author update(Author author) {
        return null;
    }

    @Override
    public void delete(String s) {

    }
}
