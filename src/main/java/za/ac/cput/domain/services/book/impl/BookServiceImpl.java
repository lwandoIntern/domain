package za.ac.cput.domain.services.book.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.domain.book.Book;
import za.ac.cput.domain.repository.book_repository.BookRepository;
import za.ac.cput.domain.repository.book_repository.impl.BookRepositoryImpl;
import za.ac.cput.domain.services.book.BookService;

@Service
public class BookServiceImpl implements BookService {

    private static BookServiceImpl service = null;
    private BookRepository repository;

    private BookServiceImpl(){
        this.repository = BookRepositoryImpl.getRepository();
    }

    public static BookServiceImpl getService(){
        if (service == null)service = new BookServiceImpl();
        return service;
    }
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
