package za.ac.cput.domain.Factory;

import za.ac.cput.domain.Factory.publisher.PublisherFactory;
import za.ac.cput.domain.domain.authors.Author;
import za.ac.cput.domain.domain.book.Book;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.domain.domain.publisher.Publisher;

public class PublisherFactoryTest {

    private Publisher publisher;
    private Author author;
    private Book book;
    @Before
    public void setUp() throws Exception {
        publisher = PublisherFactory.createPublisher(author,book,"x",null,8000,null,"CPT","WC");
    }

    @Test
    public void createPublisher() {
        Assert.assertEquals(publisher.getCellphone(),publisher.getCellphone());
    }
}