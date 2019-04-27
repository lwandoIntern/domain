package za.ac.cput.domain.Factory;

import authors.Author;
import book.Article;
import book.Book;
import publishers.Publisher;

public class ArticleFactory {
    public static Book createArticle(String num, int year, String name, Author author, Publisher publisher,String category){
        return new Article.ArticleBuilder()
                .isbnNum(num)
                .yearPublished(year)
                .title(name)
                .author(author)
                .publisher(publisher)
                .category(category)
                .build();
    }
}
