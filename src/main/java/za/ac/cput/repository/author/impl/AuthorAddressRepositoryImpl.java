package za.ac.cput.repository.author.impl;

import za.ac.cput.domain.author.AuthorAddress;
import za.ac.cput.repository.author.AuthorAddressRepository;

import java.util.HashSet;
import java.util.Set;

public class AuthorAddressRepositoryImpl implements AuthorAddressRepository {
    private static AuthorAddressRepository repository = null;
    private Set<AuthorAddress> authorAddresses;

    private AuthorAddressRepositoryImpl(){
        this.authorAddresses = new HashSet<>();
    }

    public static AuthorAddressRepository getRepository() {
        if (repository == null)repository = new AuthorAddressRepositoryImpl();
        return repository;
    }

    private AuthorAddress findAuthorAddress(String id){
        return this.authorAddresses.stream()
                .filter(authorAddress -> authorAddress.getAuthorEmail().trim().equalsIgnoreCase(id))
                .findAny()
                .orElse(null);
    }
    @Override
    public AuthorAddress create(AuthorAddress authorAddress) {
        this.authorAddresses.add(authorAddress);
        return authorAddress;
    }

    @Override
    public AuthorAddress read(String s) {
        AuthorAddress authorAddress = findAuthorAddress(s);
        return authorAddress;
    }

    @Override
    public AuthorAddress update(AuthorAddress authorAddress) {
        AuthorAddress toDelete = findAuthorAddress(authorAddress.getAuthorEmail());
        if (toDelete != null){
            this.authorAddresses.remove(authorAddress);
            return create(authorAddress);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        AuthorAddress authorAddress = findAuthorAddress(s);
        if (authorAddress != null)
            this.authorAddresses.remove(authorAddress);
    }

    @Override
    public Set<AuthorAddress> getAll() {
        return this.authorAddresses;
    }
}
