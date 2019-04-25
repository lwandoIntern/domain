package za.ac.cput.domain.repository.impl;

import authors.Author;
import za.ac.cput.domain.repository.AuthorRepository;

import java.util.HashSet;
import java.util.Iterator;
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
        //List all authors
        repository.getAll().forEach(authorSet::add);
        return authorSet;
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
        Iterator<Author> iterable = authorSet.iterator();

        while (iterable.hasNext()){
            iterable.next();
        }
        return null;
    }

    @Override
    public void delete(String s) {
        authorSet.removeIf(t ->t.getAuthId().equals(s));
    }
}
