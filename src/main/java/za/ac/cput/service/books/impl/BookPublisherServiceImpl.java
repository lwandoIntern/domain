package za.ac.cput.service.books.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.books.BookPublisher;
import za.ac.cput.repository.books.BookPublisherRepository;
import za.ac.cput.repository.books.impl.BookPublisherRepositoryImpl;
import za.ac.cput.service.books.BookPublisherService;


import java.util.Set;

@Service
public class BookPublisherServiceImpl implements BookPublisherService {
    private static BookPublisherService bookPublisherService = null;
    private BookPublisherRepository bookPublishers;

    private BookPublisherServiceImpl(){
        this.bookPublishers = BookPublisherRepositoryImpl.getBookPublisherRepository();
    }

    public static BookPublisherService getBookPublisherService() {
        if (bookPublisherService == null)bookPublisherService = new BookPublisherServiceImpl();
        return bookPublisherService;
    }


    @Override
    public BookPublisher create(BookPublisher bookPublisher) {
        return this.bookPublishers.create(bookPublisher);
    }

    @Override
    public BookPublisher read(String s) {
        return this.bookPublishers.read(s);
    }

    @Override
    public BookPublisher update(BookPublisher bookPublisher) {
        return this.bookPublishers.update(bookPublisher);
    }

    @Override
    public void delete(String s) {
         this.bookPublishers.delete(s);
    }

    @Override
    public Set<BookPublisher> getAll() {
        return this.bookPublishers.getAll();
    }
}
