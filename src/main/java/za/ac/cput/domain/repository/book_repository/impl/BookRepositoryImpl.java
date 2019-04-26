package za.ac.cput.domain.repository.book_repository.impl;


import book.Book;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import za.ac.cput.domain.repository.book_repository.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        repository.getAll().forEach(books::add);
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
        int i = books.indexOf(book);
        return books.get(i);
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
