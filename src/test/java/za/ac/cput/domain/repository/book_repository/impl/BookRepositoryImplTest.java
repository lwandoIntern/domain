package za.ac.cput.domain.repository.book_repository.impl;

import authors.Author;
import book.Book;
import org.junit.Before;
import org.junit.Test;
import publishers.Publisher;
import za.ac.cput.domain.Factory.ArticleFactory;
import za.ac.cput.domain.Factory.AuthorFactory;
import za.ac.cput.domain.Factory.HardCopyFactory;
import za.ac.cput.domain.Factory.PublisherFactory;
import za.ac.cput.domain.repository.book_repository.BookRepository;

import static org.junit.Assert.*;

public class BookRepositoryImplTest {

    private BookRepository repository;
    private Book book;
    private Author author;
    private Publisher publisher;

    @Before
    public void setUp() throws Exception {
        repository = BookRepositoryImpl.getRepository();
        author = AuthorFactory.createAuthor("Zoe","Saldana","555-747-8164","555-814-7414",
                2166,"MIT","LA","",14);
        publisher = PublisherFactory.createPublisher(author,book,"Norman Publishers","0215489963",8000,"D6",
                "CPT","WC");
        book = ArticleFactory.createArticle("1",2012,"Cyberwarfare At its Best",author,publisher,"Technology");
    }

    @Test
    public void getAll() {
        System.out.println(repository.getAll());
        assertEquals(repository.getAll(),repository.getAll());
    }

    @Test
    public void create() {
        assertEquals(repository.create(book),repository.create(book));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void read() {
        assertNull(repository.read(book));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void update() {
        assertEquals(repository.update(book),repository.update(book));
    }

    @Test
    public void delete() {
        repository.delete(book.getIsbnNum());
    }
}