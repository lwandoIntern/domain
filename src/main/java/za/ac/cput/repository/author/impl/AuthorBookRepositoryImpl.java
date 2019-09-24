package za.ac.cput.repository.author.impl;

import za.ac.cput.domain.author.AuthorBook;
import za.ac.cput.repository.author.AuthorBookRepository;

import java.util.HashSet;
import java.util.Set;

public class AuthorBookRepositoryImpl implements AuthorBookRepository {
    private static AuthorBookRepository repository = null;
    private Set<AuthorBook> authorBooks;

    private AuthorBookRepositoryImpl(){
        this.authorBooks = new HashSet<>();
    }

    public static AuthorBookRepository getRepository() {
        if (repository == null)repository = new AuthorBookRepositoryImpl();
        return repository;
    }

    private AuthorBook findAuthorBook(String id){
        return this.authorBooks.stream()
                .filter(authorBook -> authorBook.getAuthorEmail().trim().equalsIgnoreCase(id))
                .findAny()
                .orElse(null);
    }
    @Override
    public AuthorBook create(AuthorBook authorBook) {
        this.authorBooks.add(authorBook);
        return authorBook;
    }

    @Override
    public AuthorBook read(String s) {
        AuthorBook authorBook = findAuthorBook(s);
        return authorBook;
    }

    @Override
    public AuthorBook update(AuthorBook authorBook) {
        AuthorBook toDelete = findAuthorBook(authorBook.getAuthorEmail());
        if (toDelete !=null){
            this.authorBooks.remove(toDelete);
            return create(authorBook);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        AuthorBook authorBook = findAuthorBook(s);
        if (authorBook !=null)
            this.authorBooks.remove(authorBook);
    }

    @Override
    public Set<AuthorBook> getAll() {
        return this.authorBooks;
    }
}
