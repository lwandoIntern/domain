package za.ac.cput.service.author.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.author.Author;
import za.ac.cput.repository.author.AuthorRepository;
import za.ac.cput.repository.author.impl.AuthorRepositoryImpl;
import za.ac.cput.service.author.AuthorService;

import java.util.Set;

@Service
public class AuthorServiceImpl implements AuthorService {
    private static AuthorService service = null;
    private AuthorRepository repository;
    private AuthorServiceImpl(){
        this.repository = AuthorRepositoryImpl.getRepository();
    }

    public static AuthorService getService() {
        if (service == null)service = new AuthorServiceImpl();
        return service;
    }

    @Override
    public Author create(Author author) {
        return repository.create(author);
    }

    @Override
    public Author read(String s) {
        return repository.read(s);
    }

    @Override
    public Author update(Author author) {
        return repository.update(author);
    }

    @Override
    public void delete(String s) {
        repository.delete(s);
    }

    @Override
    public Set<Author> getAll() {
        return repository.getAll();
    }

    @Override
    public Author getByFullName(String fullName) {
        return repository.getByFullName(fullName);
    }
}
