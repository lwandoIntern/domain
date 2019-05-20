package za.ac.cput.domain.services.book.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.domain.book.Book;
import za.ac.cput.domain.repository.book.BookRepository;
import za.ac.cput.domain.services.book.BookService;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository repository;

    @Override
    public Book create(Book book) {
        return this.repository.create(book);
    }

    @Override
    public Book update(Book book) {
        return this.repository.update(book);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Book read(Book book) {
        return this.repository.read(book);
    }
}
