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
    private BookPublisherRepository repository;

    private BookPublisherServiceImpl(){

    }

    public static BookPublisherService getBookPublisherService() {
        if (bookPublisherService == null)bookPublisherService = new BookPublisherServiceImpl();
        return bookPublisherService;
    }


    @Override
    public BookPublisher create(BookPublisher bookPublisher) {
        return this.repository.save(bookPublisher);
    }

    @Override
    public BookPublisher read(String s) {
        return this.repository.getOne(s);
    }

    @Override
    public BookPublisher update(BookPublisher bookPublisher) {
        return this.repository.save(bookPublisher);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }

    @Override
    public Set<BookPublisher> getAll() {
        Set<BookPublisher> bookPublishersSet = new HashSet<>();
        bookPublishersSet.addAll(this.repository.findAll());
        return bookPublishersSet;
    }
}
