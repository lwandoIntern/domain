package za.ac.cput.repository.books.impl;

import za.ac.cput.domain.books.Book;
import za.ac.cput.repository.books.BookRepository;

import java.util.HashSet;
import java.util.Set;

public class BookRepositoryImpl implements BookRepository {
    private static BookRepository bookRepository = null;
    private Set<Book> books;

    private BookRepositoryImpl(){
        this.books = new HashSet<>();
    }

    public static BookRepository getBookRepository() {
        if (bookRepository == null)bookRepository = new BookRepositoryImpl();
        return bookRepository;
    }

    private Book findBook(String s){
        return this.books.stream()
                .filter(book -> book.getIsbn().trim().equalsIgnoreCase(s))
                .findAny()
                .orElse(null);
    }
    @Override
    public Book create(Book book) {
        this.books.add(book);
        return book;
    }

    @Override
    public Book read(String s) {
        Book book = findBook(s);
        return book;
    }

    @Override
    public Book update(Book book) {
        Book toDelete = findBook(book.getIsbn());
        if (toDelete != null){
            this.books.remove(toDelete);
            return create(book);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        Book book = findBook(s);
        if (book != null)this.books.remove(book);
    }

    @Override
    public Set<Book> getAll() {
        return this.books;
    }

    @Override
    public Book getByTitle(String title) {
        return null;
    }
}
