package za.ac.cput.service.author.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        this.repository.save(authorDemography);
        return this.repository.getOne(authorDemography.getAuthorEmail());
    }

    @Override
    public AuthorDemography read(String s) {
        return repository.getOne(s);
    }

    @Override
    public AuthorDemography update(AuthorDemography authorDemography) {
        AuthorDemography authorDemography1 = this.repository.getOne(authorDemography.getAuthorEmail());
        if (authorDemography1 == authorDemography){
            this.repository.deleteById(authorDemography1.getAuthorEmail());
            this.repository.save(authorDemography);
            return this.repository.getOne(authorDemography.getAuthorEmail());
        }
        return null;
    }

    @Override
    public void delete(String s) {
        if (this.repository.getOne(s) != null)
            this.repository.deleteById(s);
    }

    @Override
    public Set<AuthorDemography> getAll() {
        Set<AuthorDemography> authorDemographies = new HashSet<>();
        authorDemographies.addAll(this.repository.findAll());
        return authorDemographies;
    }
}
