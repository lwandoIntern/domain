package za.ac.cput.service.author.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.author.AuthorAddress;
import za.ac.cput.domain.author.AuthorBook;
import za.ac.cput.repository.author.AuthorAddressRepository;

import za.ac.cput.service.author.AuthorAddressService;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthorAddressServiceImpl implements AuthorAddressService {
    private static AuthorAddressService service = null;
    @Autowired
    private AuthorAddressRepository repository;

    private AuthorAddressServiceImpl(){

    }

    public static AuthorAddressService getService() {
        if (service ==null)service = new AuthorAddressServiceImpl();
        return service;
    }


    @Override
    public AuthorAddress create(AuthorAddress authorAddress) {
        return this.repository.save(authorAddress);
    }

    @Override
    public AuthorAddress read(String s) {
        return this.repository.getOne(s);
    }

    @Override
    public AuthorAddress update(AuthorAddress authorAddress) {
        return this.repository.save(authorAddress);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }

    @Override
    public Set<AuthorAddress> getAll() {
        Set<AuthorAddress> set = new HashSet<>();
        set.addAll(this.repository.findAll());
        return set;
    }
}
