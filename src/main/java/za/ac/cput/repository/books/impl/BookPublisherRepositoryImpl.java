package za.ac.cput.repository.books.impl;

import za.ac.cput.domain.books.BookCategory;
import za.ac.cput.domain.books.BookPublisher;
import za.ac.cput.repository.books.BookCategoryRepository;
import za.ac.cput.repository.books.BookPublisherRepository;

import java.util.HashSet;
import java.util.Set;

public class BookPublisherRepositoryImpl implements  BookPublisherRepository {
    private static BookPublisherRepository bookPublisherRepository = null;
    private Set<BookPublisher> bookPublishers;

    private BookPublisherRepositoryImpl(){
        this.bookPublishers = new HashSet<>();
    }

    public static BookPublisherRepository getBookPublisherRepository() {
        if (bookPublisherRepository == null)bookPublisherRepository = new BookPublisherRepositoryImpl();
        return bookPublisherRepository;
    }
    private BookPublisher findBookPublisher(String id){
        return this.bookPublishers.stream()
                .filter(bookPublisher -> bookPublisher.getIsbn().trim().equalsIgnoreCase(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public BookPublisher create(BookPublisher bookPublisher) {
        this.bookPublishers.add(bookPublisher);
        return bookPublisher;
    }

    @Override
    public BookPublisher read(String s) {
        BookPublisher bookPublisher = findBookPublisher(s);
        return bookPublisher;
    }

    @Override
    public BookPublisher update(BookPublisher bookPublisher) {
        BookPublisher toDelete = findBookPublisher(bookPublisher.getIsbn());
        if (toDelete != null){
            this.bookPublishers.remove(toDelete);
            return create(bookPublisher);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        BookPublisher bookPublisher = findBookPublisher(s);
        if (bookPublisher != null)this.bookPublishers.remove(bookPublisher);
    }

    @Override
    public Set<BookPublisher> getAll() {
        return this.bookPublishers;
    }
}
