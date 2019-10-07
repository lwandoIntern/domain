package za.ac.cput.service.books.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.books.Book;
import za.ac.cput.repository.books.BookRepository;
import za.ac.cput.service.books.BookService;


import java.util.HashSet;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService {
    private static BookService bookService = null;
    @Autowired
    private BookRepository bookRepository;

    private BookServiceImpl(){}

    public static BookService getBookService() {
        if (bookService == null)bookService = new BookServiceImpl();
        return bookService;
    }

    @Override
    public Book getByTitle(String bookTitle) {
        return getAll().stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(bookTitle))
                .findAny()
                .get();
    }

    @Override
    public Book create(Book book) {
        this.bookRepository.save(book);
        return this.bookRepository.getOne(book.getIsbn());
    }

    @Override
    public Book read(String s) {
        return this.bookRepository.getOne(s);
    }

    @Override
    public Book update(Book book) {
        Book book1 = this.bookRepository.getOne(book.getIsbn());
        if (book1 == book){
            this.bookRepository.delete(book1);
            this.bookRepository.save(book);
            return this.bookRepository.getOne(book.getIsbn());
        }
        return null;
    }

    @Override
    public void delete(String s) {
        if (this.bookRepository.getOne(s) != null)
            this.bookRepository.deleteById(s);
    }

    @Override
    public Set<Book> getAll() {
        Set<Book> books = new HashSet<>();
        books.addAll(this.bookRepository.findAll());
        return books;
    }
}
