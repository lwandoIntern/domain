package za.ac.cput.domain.services.book.impl;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Factory.author.AuthorFactory;
import za.ac.cput.domain.Factory.books.ArticleFactory;
import za.ac.cput.domain.Factory.books.HardCopyFactory;
import za.ac.cput.domain.Factory.books.SoftCopyFactory;
import za.ac.cput.domain.Factory.publisher.PublisherFactory;
import za.ac.cput.domain.domain.authors.Author;
import za.ac.cput.domain.domain.book.Book;
import za.ac.cput.domain.domain.publishers.Publisher;
import za.ac.cput.domain.repository.book_repository.impl.BookRepositoryImpl;

import static org.junit.Assert.*;

public class BookServiceImplTest {

    @Autowired
    private static BookServiceImpl service;
    private Book book;
    private Publisher publisher;
    private Author author;

    @Before
    public void setUp() throws Exception {
        author = AuthorFactory.createAuthor("Nceba","Goniwe","0740740918","0217149555",7441,"MLT",
                "CPT","WC",5);
        publisher = PublisherFactory.createPublisher(author,book,"Norman Publishers","0215489963",8000,"D6",
                "CPT","WC");
        book = ArticleFactory.createArticle(2012,"Cyberwarfare At its Best",author,publisher,"Technology");
    }

    @Test(expected = NullPointerException.class)
    public void create() {
        assertEquals(service.create(book),service.create(book));
    }

    @Test(expected = NullPointerException.class)
    public void update() {
        assertNotNull(service.update(book));
    }

    @Test(expected = NullPointerException.class)
    public void delete() {
        service.delete(book.getIsbnNum());
    }

    @Test(expected = NullPointerException.class)
    public void read() {
        assertNotNull(service.read(book));
    }
}