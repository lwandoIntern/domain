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
        repository.getAll().forEach(books::add);
        return books;
    }

    @Override
    public Book create(Book book) {
        this.books.add(book);
        return book;
    }

    @Override
    public Book read(Book book) {
        return book;
    }

    @Override
    public Book update(Book book) {
        for (int i = 0; i < books.size(); i++) {
            if(books.get(i).getIsbnNum().equals(book.getIsbnNum())){

            }
        }
        return book;
    }

    @Override
    public void delete(String s) {
        books.removeIf(t->t.getIsbnNum().equals(s));
    }
}
