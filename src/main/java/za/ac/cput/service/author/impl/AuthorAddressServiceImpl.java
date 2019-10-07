package za.ac.cput.service.author.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.ac.cput.domain.author.AuthorAddress;

import za.ac.cput.repository.author.AuthorAddressRepository;
import za.ac.cput.service.author.AuthorAddressService;


import java.util.HashSet;
import java.util.Set;

@Service
public class AuthorAddressServiceImpl implements AuthorAddressService {
    private static AuthorAddressService service = null;
    @Autowired
    private AuthorAddressRepository repository;

    private AuthorAddressServiceImpl(){}

    public static AuthorAddressService getService() {
        if (service ==null)service = new AuthorAddressServiceImpl();
        return service;
    }

    @Override
    public AuthorAddress create(AuthorAddress authorAddress) {
        this.repository.save(authorAddress);
        return this.repository.getOne(authorAddress.getAuthorEmail());
    }

    @Override
    public AuthorAddress read(String s) {
        return repository.getOne(s);
    }

    @Override
    public AuthorAddress update(AuthorAddress authorAddress) {
        AuthorAddress authorAddress1 = this.repository.getOne(authorAddress.getAuthorEmail());
        if (authorAddress1 == authorAddress){
            this.repository.delete(authorAddress1);
            this.repository.save(authorAddress);
            return this.repository.getOne(authorAddress.getAuthorEmail());
        }
        return null;
    }

    @Override
    public void delete(String s) {
        if (this.repository.getOne(s) != null)
            repository.deleteById(s);
    }

    @Override
    public Set<AuthorAddress> getAll() {
        Set<AuthorAddress> authorAddresses = new HashSet<>();
        authorAddresses.addAll(this.repository.findAll());
        return authorAddresses;
    }
}
