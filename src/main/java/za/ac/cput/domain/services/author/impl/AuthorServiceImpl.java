package za.ac.cput.domain.services.author.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.domain.authors.Author;
import za.ac.cput.domain.repository.authorRepository.AuthorRepository;
import za.ac.cput.domain.repository.authorRepository.impl.AuthorRepositoryImpl;
import za.ac.cput.domain.services.author.AuthorService;

import java.util.Set;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorServiceImpl service = null;
    private AuthorRepository repository;

    private AuthorServiceImpl(){
        this.repository = AuthorRepositoryImpl.getAuthorRepository();
    }

    public AuthorServiceImpl getService() {
        if (service == null)service = new AuthorServiceImpl();
        return service;
    }

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
