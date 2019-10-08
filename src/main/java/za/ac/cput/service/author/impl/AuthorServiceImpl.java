package za.ac.cput.service.author.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.author.Author;
import za.ac.cput.repository.author.AuthorRepository;
import za.ac.cput.service.author.AuthorService;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthorServiceImpl implements AuthorService {
    private static AuthorService service = null;
    @Autowired
    private AuthorRepository repository;
    private AuthorServiceImpl(){ }

    public static AuthorService getService() {
        if (service == null)service = new AuthorServiceImpl();
        return service;
    }

    @Override
    public Author create(Author author) {
        this.repository.save(author);
        return this.repository.findAll().stream()
                .filter(author1 -> author1 == author)
                .findAny()
                .get();
    }

    @Override
    public Author read(String authorid) {
        return repository.findAll().stream().filter(author1 -> author1.getAuthorEmail().equalsIgnoreCase(authorid)).findAny().get();
    }

    @Override
    public Author update(Author author) {
        return this.repository.save(this.repository.findAll().stream()
                .filter(author1 -> author1 == author)
                .findAny()
                .get());
    }

    @Override
    public void delete(String authorId) {
        this.repository.deleteById(authorId);
    }

    @Override
    public Set<Author> getAll() {
        Set<Author> authors = new HashSet<>();
        authors.addAll(repository.findAll());
        return authors;
    }

    @Override
    public Author getByFullName(String fullName) {
        Author author = this.repository.findAll().stream()
                .filter(author1 -> (author1.getFirstName() + " "+ author1.getLastName()).equalsIgnoreCase(fullName))
                .findAny().get();
        return author;
    }
}
