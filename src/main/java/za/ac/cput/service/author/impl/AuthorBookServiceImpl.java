package za.ac.cput.service.author.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.author.AuthorBook;
import za.ac.cput.repository.author.AuthorBookRepository;
import za.ac.cput.repository.author.impl.AuthorBookRepositoryImpl;
import za.ac.cput.service.author.AuthorBookService;

import java.util.Set;

@Service
public class AuthorBookServiceImpl implements AuthorBookService {
    private static AuthorBookService service = null;
    private AuthorBookRepository repository;

    private AuthorBookServiceImpl(){
        this.repository = AuthorBookRepositoryImpl.getRepository();
    }

    public static AuthorBookService getService() {
        if (service == null)service = new AuthorBookServiceImpl();
        return service;
    }

    @Override
    public AuthorBook create(AuthorBook authorBook) {
        return repository.create(authorBook);
    }

    @Override
    public AuthorBook read(String s) {
        return repository.read(s);
    }

    @Override
    public AuthorBook update(AuthorBook authorBook) {
        return repository.update(authorBook);
    }

    @Override
    public void delete(String s) {
        repository.delete(s);
    }

    @Override
    public Set<AuthorBook> getAll() {
        return repository.getAll();
    }
}
