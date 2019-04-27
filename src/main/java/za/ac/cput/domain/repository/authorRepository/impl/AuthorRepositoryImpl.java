package za.ac.cput.domain.repository.authorRepository.impl;

import authors.Author;
import za.ac.cput.domain.repository.authorRepository.AuthorRepository;

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

        return authorSet;
    }

    @Override
    public Author create(Author author) {
        this.authorSet.add(author);
        return author;
    }

    @Override
    public Author read(Author author) {
        if (repository.authorSet.contains(author)){
            for(Author author1:authorSet){
                if (author1.equals(author))
                    return author1;
            }
        }
        return null;
    }

    @Override
    public Author update(Author author) {
        if (authorSet.contains(author)){
            for (Author au: authorSet) {
                if (au.equals(author))
                    return au;
            }
        }
        return null;
    }

    @Override
    public void delete(String s) {
        authorSet.removeIf(t ->t.getAuthId().equals(s));
    }
}
