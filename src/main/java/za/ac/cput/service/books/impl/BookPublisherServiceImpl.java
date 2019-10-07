package za.ac.cput.service.books.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.books.BookPublisher;
import za.ac.cput.repository.books.BookPublisherRepository;
import za.ac.cput.service.books.BookPublisherService;


import java.util.HashSet;
import java.util.Set;

@Service
public class BookPublisherServiceImpl implements BookPublisherService {
    private static BookPublisherService bookPublisherService = null;
    @Autowired
    private BookPublisherRepository bookPublishers;

    private BookPublisherServiceImpl(){}

    public static BookPublisherService getBookPublisherService() {
        if (bookPublisherService == null)bookPublisherService = new BookPublisherServiceImpl();
        return bookPublisherService;
    }


    @Override
    public BookPublisher create(BookPublisher bookPublisher) {
        this.bookPublishers.save(bookPublisher);
        return this.bookPublishers.getOne(bookPublisher.getPublisherId());
    }

    @Override
    public BookPublisher read(String s) {
        return this.bookPublishers.getOne(s);
    }

    @Override
    public BookPublisher update(BookPublisher bookPublisher) {
        BookPublisher bookPublisher1 = this.bookPublishers.getOne(bookPublisher.getPublisherId());
        if (bookPublisher1 == bookPublisher){
            this.bookPublishers.delete(bookPublisher1);
            this.bookPublishers.save(bookPublisher);
            return this.bookPublishers.getOne(bookPublisher.getPublisherId());
        }
        return null;
    }

    @Override
    public void delete(String s) {
         this.bookPublishers.deleteById(s);
    }

    @Override
    public Set<BookPublisher> getAll() {
        Set<BookPublisher> bookPublishers = new HashSet<>();
        bookPublishers.addAll(this.bookPublishers.findAll());
        return bookPublishers;
    }
}
