package za.ac.cput.domain.repository.book_repository.impl;


import book.Book;
import za.ac.cput.domain.repository.book_repository.BookRepository;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {
    private static BookRepositoryImpl repository = null;
    private List<Book> books;

    private BookRepositoryImpl(){
        this.books = new ArrayList<>();
    }

    public static BookRepository getRepository(){
        if (repository == null)repository = new BookRepositoryImpl();
        return repository;
    }

    @Override
    public List<Book> getAll() {
        //List all books

        return books;
    }

    @Override
    public Book create(Book book) {
        //new book
        //this.books.add(book);
        repository.books.add(book);
        int i = books.indexOf(book);
        return books.get(i);
    }

    @Override
    public Book read(Book book) {
        int i = repository.books.indexOf(book);
        return repository.books.get(i);
    }

    @Override
    public Book update(Book book) {
        int booking = books.indexOf(book);
        return repository.books.get(booking);
    }

    @Override
    public void delete(String s) {
        books.removeIf(t->t.getIsbnNum().equals(s));
    }
}
