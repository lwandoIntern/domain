package za.ac.cput.domain.Factory;

import za.ac.cput.domain.Factory.books.ArticleFactory;
import za.ac.cput.domain.domain.authors.Author;
import za.ac.cput.domain.domain.book.Book;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.domain.domain.publisher.Publisher;

public class ArticleFactoryTest {

    private Book article;
    private Author author;
    private Publisher publisher;
    @Before
    public void setUp() throws Exception {
        article = ArticleFactory.createArticle(2010,"Dooms Day 12",author,publisher,"Horror");
    }

    @Test
    public void createArticle() {
        Assert.assertEquals(article.getAuthor(),article.getAuthor());
    }
}