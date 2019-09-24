package za.ac.cput.repository.author.impl;

import za.ac.cput.domain.author.Author;
import za.ac.cput.repository.author.AuthorRepository;

import java.util.HashSet;
import java.util.Set;

public class AuthorRepositoryImpl implements AuthorRepository {
    private static AuthorRepository repository = null;
    private Set<Author> authors;

    private AuthorRepositoryImpl(){
        this.authors = new HashSet<>();
    }

    public static AuthorRepository getRepository() {
        if (repository == null)repository = new AuthorRepositoryImpl();
        return repository;
    }

    private Author findAuthor(String id){
        return this.authors.stream()
                .filter(author->author.getAuthorEmail().trim().equalsIgnoreCase(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public Author create(Author author) {
        this.authors.add(author);
        return author;
    }

    @Override
    public Author read(String s) {
        Author author = findAuthor(s);
        return author;
    }

    @Override
    public Author update(Author author) {
        Author toDelete = findAuthor(author.getAuthorEmail());
        if (toDelete != null){
            this.authors.remove(toDelete);
            return create(author);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        Author author = findAuthor(s);
        if (author != null)
            this.authors.remove(author);
    }

    @Override
    public Set<Author> getAll() {
        return this.authors;
    }

    @Override
    public Author getByFullName(String fullName) {
        return this.authors.stream().filter(author -> (author.getFirstName() + " "+ author.getLastName()).equalsIgnoreCase(fullName))
                .findAny()
                .orElse(null);
    }
}
