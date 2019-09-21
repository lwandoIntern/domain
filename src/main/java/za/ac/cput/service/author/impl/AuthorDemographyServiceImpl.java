package za.ac.cput.service.author.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.author.AuthorDemography;
import za.ac.cput.repository.author.AuthorDemographyRepository;
import za.ac.cput.repository.author.impl.AuthorDemographyRepositoryImpl;
import za.ac.cput.service.author.AuthorDemographyService;

import java.util.Set;

@Service
public class AuthorDemographyServiceImpl implements AuthorDemographyService {
    private static AuthorDemographyService service = null;
    private AuthorDemographyRepository repository;
    private AuthorDemographyServiceImpl(){
        this.repository = AuthorDemographyRepositoryImpl.getRepository();
    }

    public static AuthorDemographyService getService() {
        if (service == null)service = new AuthorDemographyServiceImpl();
        return service;
    }

    @Override
    public AuthorDemography create(AuthorDemography authorDemography) {
        return repository.create(authorDemography);
    }

    @Override
    public AuthorDemography read(String s) {
        return repository.read(s);
    }

    @Override
    public AuthorDemography update(AuthorDemography authorDemography) {
        return repository.update(authorDemography);
    }

    @Override
    public void delete(String s) {
        repository.delete(s);
    }

    @Override
    public Set<AuthorDemography> getAll() {
        return repository.getAll();
    }
}
