package za.ac.cput.domain.repository.book.impl;

import za.ac.cput.domain.domain.authors.Author;
import za.ac.cput.domain.domain.book.Book;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.domain.domain.publisher.Publisher;
import za.ac.cput.domain.Factory.books.ArticleFactory;
import za.ac.cput.domain.Factory.author.AuthorFactory;
import za.ac.cput.domain.Factory.publisher.PublisherFactory;
import za.ac.cput.domain.repository.book.BookRepository;

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
        book = ArticleFactory.createArticle(2012,"Cyberwarfare At its Best",author,publisher,"Technology");
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