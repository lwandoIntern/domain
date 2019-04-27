package za.ac.cput.domain.repository.publisherRepository.impl;

import authors.Author;
import book.Book;
import org.junit.Before;
import org.junit.Test;
import publishers.Publisher;
import za.ac.cput.domain.Factory.ArticleFactory;
import za.ac.cput.domain.Factory.AuthorFactory;
import za.ac.cput.domain.Factory.PublisherFactory;
import za.ac.cput.domain.repository.publisherRepository.PublisherRepository;

import static org.junit.Assert.*;

public class PublisherRepoImplTest {

    private PublisherRepository repository;
    private Publisher publisher;
    private Author author;
    private Book book;
    @Before
    public void setUp() throws Exception {
        author = AuthorFactory.createAuthor("Zoe","Saldana","555-747-8164","555-814-7414",
                2166,"MIT","LA","",14);
        book = ArticleFactory.createArticle("1",2012,"Cyberwarfare At its Best",author,publisher,
                "Technology");
        publisher = PublisherFactory.createPublisher(author,book,"Norman Publishers","0215489963",8000,"D6",
                "CPT","WC");
        repository = PublisherRepoImpl.getRepo();
    }

    @Test
    public void findById() {
        assertEquals(repository.findById(publisher.getPublishId()),repository.findById(publisher.getPublishId()));
    }

    @Test(expected = AssertionError.class)
    public void create() {
        assertEquals(repository.create(publisher),repository.create(publisher));
    }

    @Test
    public void read() {
        assertEquals(repository.read(publisher),repository.read(publisher));
    }

    @Test(expected = AssertionError.class)
    public void update() {
        assertEquals(repository.update(publisher),repository.update(publisher));
    }

    @Test
    public void delete() {
        repository.delete(publisher.getPublishId());
    }
}