package za.ac.cput.service.books.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.books.Book;
import za.ac.cput.repository.books.BookRepository;
import za.ac.cput.repository.books.impl.BookRepositoryImpl;
import za.ac.cput.service.books.BookService;

import java.util.Set;

@Service
public class BookServiceImpl implements BookService {
    private static BookService bookService = null;
    private BookRepository bookRepository;

    private BookServiceImpl(){
        this.bookRepository = BookRepositoryImpl.getBookRepository();
    }

    public static BookService getBookService() {
        if (bookService == null)bookService = new BookServiceImpl();
        return bookService;
    }

    @Override
    public Book getByTitle(String bookTitle) {
        return this.bookRepository.getByTitle(bookTitle);
    }

    @Override
    public Book create(Book book) {
        return this.bookRepository.create(book);
    }

    @Override
    public Book read(String s) {
        return this.bookRepository.read(s);
    }

    @Override
    public Book update(Book book) {
        return this.bookRepository.update(book);
    }

    @Override
    public void delete(String s) {
        this.bookRepository.delete(s);
    }

    @Override
    public Set<Book> getAll() {
        return this.bookRepository.getAll();
    }
}
