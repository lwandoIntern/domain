package Factory;

import authors.Author;
import book.Book;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import publishers.Publisher;

public class ArticleFactoryTest {

    private Book article;
    private Author author;
    private Publisher publisher;
    @Before
    public void setUp() throws Exception {
        article = ArticleFactory.createArticle(1,2010,"Dooms Day 12",author,publisher,"Horror");
    }

    @Test
    public void createArticle() {
        Assert.assertEquals(article.getAuthor(),article.getAuthor());
    }
}