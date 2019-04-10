package Factory;

import model.Book;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookFactoryTest {


    private Book book;
    @Before
    public void setUp() throws Exception {
        book = BookFactory.createBook("144444444","Nceba","Deseased","Fifth",2010);
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void createBook(){
        Assert.assertEquals(book.getAuthor(),book.getAuthor());
    }
}