package za.ac.cput.service.author.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.author.AuthorAddress;
import za.ac.cput.repository.author.AuthorAddressRepository;
import za.ac.cput.repository.author.impl.AuthorAddressRepositoryImpl;
import za.ac.cput.service.author.AuthorAddressService;

import java.util.Set;

@Service
public class AuthorAddressServiceImpl implements AuthorAddressService {
    private static AuthorAddressService service = null;
    private AuthorAddressRepository repository;

    private AuthorAddressServiceImpl(){
        this.repository = AuthorAddressRepositoryImpl.getRepository();
    }

    public static AuthorAddressService getService() {
        if (service ==null)service = new AuthorAddressServiceImpl();
        return service;
    }

    @Override
    public AuthorAddress create(AuthorAddress authorAddress) {
        return repository.create(authorAddress);
    }

    @Override
    public AuthorAddress read(String s) {
        return repository.read(s);
    }

    @Override
    public AuthorAddress update(AuthorAddress authorAddress) {
        return repository.update(authorAddress);
    }

    @Override
    public void delete(String s) {
        repository.delete(s);
    }

    @Override
    public Set<AuthorAddress> getAll() {
        return repository.getAll();
    }
}
