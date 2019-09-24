package za.ac.cput.repository.author.impl;

import za.ac.cput.domain.author.AuthorDemography;
import za.ac.cput.repository.author.AuthorDemographyRepository;

import java.util.HashSet;
import java.util.Set;

public class AuthorDemographyRepositoryImpl implements AuthorDemographyRepository {

    private static AuthorDemographyRepository repository = null;
    private Set<AuthorDemography> authorDemographies;

    private AuthorDemographyRepositoryImpl(){
        this.authorDemographies = new HashSet<>();
    }

    public static AuthorDemographyRepository getRepository() {
        if (repository == null)repository = new AuthorDemographyRepositoryImpl();
        return repository;
    }

    private AuthorDemography findAuthorDemography(String authorId){
        return this.authorDemographies.stream()
                .filter(authorDemography -> authorDemography.getAuthorEmail().trim().equalsIgnoreCase(authorId))
                .findAny()
                .orElse(null);
    }
    @Override
    public AuthorDemography create(AuthorDemography authorDemography) {
        this.authorDemographies.add(authorDemography);
        return authorDemography;
    }

    @Override
    public AuthorDemography read(String s) {
        AuthorDemography authorDemography = findAuthorDemography(s);
        return authorDemography;
    }

    @Override
    public AuthorDemography update(AuthorDemography authorDemography) {
        AuthorDemography toDelete = findAuthorDemography(authorDemography.getAuthorEmail());
        if (toDelete != null){
            this.authorDemographies.remove(toDelete);
            return create(authorDemography);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        AuthorDemography authorDemography = findAuthorDemography(s);
        if (authorDemography != null)
            this.authorDemographies.remove(authorDemography);
    }

    @Override
    public Set<AuthorDemography> getAll() {
        return this.authorDemographies;
    }
}
