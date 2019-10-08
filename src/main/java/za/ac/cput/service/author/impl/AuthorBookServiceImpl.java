package za.ac.cput.service.author.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.author.AuthorBook;
import za.ac.cput.repository.author.AuthorBookRepository;

import za.ac.cput.service.author.AuthorBookService;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthorBookServiceImpl implements AuthorBookService {
    private static AuthorBookService service = null;
    @Autowired
    private AuthorBookRepository repository;

    private AuthorBookServiceImpl(){}

    public static AuthorBookService getService() {
        if (service == null)service = new AuthorBookServiceImpl();
        return service;
    }


    @Override
    public AuthorBook create(AuthorBook authorBook) {
        return this.repository.save(authorBook);
    }

    @Override
    public AuthorBook read(String s) {
        return this.repository.getOne(s);
    }

    @Override
    public AuthorBook update(AuthorBook authorBook) {
        return this.repository.save(authorBook);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }

    @Override
    public Set<AuthorBook> getAll() {
        Set<AuthorBook> set = new HashSet<>();
        set.addAll(this.repository.findAll());
        return set;
    }
}
