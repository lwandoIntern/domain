package za.ac.cput.domain.services.author.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.domain.authors.Author;
import za.ac.cput.domain.repository.author.AuthorRepository;
import za.ac.cput.domain.services.author.AuthorService;

import java.util.Set;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository repository;


    @Override
    public Set<Author> getAllAuthors() {
        return this.repository.getAll();
    }

    @Override
    public Author create(Author author) {
        return this.repository.create(author);
    }

    @Override
    public Author update(Author author) {
        return this.repository.update(author);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Author read(Author author) {
        return this.repository.read(author);
    }
}
