package za.ac.cput.service.author.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.author.AuthorBook;
import za.ac.cput.domain.author.AuthorDemography;
import za.ac.cput.repository.author.AuthorDemographyRepository;

import za.ac.cput.service.author.AuthorDemographyService;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthorDemographyServiceImpl implements AuthorDemographyService {
    private static AuthorDemographyService service = null;
    @Autowired
    private AuthorDemographyRepository repository;
    private AuthorDemographyServiceImpl(){}

    public static AuthorDemographyService getService() {
        if (service == null)service = new AuthorDemographyServiceImpl();
        return service;
    }


    @Override
    public AuthorDemography create(AuthorDemography authorDemography) {
        return this.repository.save(authorDemography);
    }

    @Override
    public AuthorDemography read(String s) {
        return this.repository.getOne(s);
    }

    @Override
    public AuthorDemography update(AuthorDemography authorDemography) {
        return this.repository.save(authorDemography);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }

    @Override
    public Set<AuthorDemography> getAll() {
        Set<AuthorDemography> set = new HashSet<>();
        set.addAll(this.repository.findAll());
        return set;
    }
}
