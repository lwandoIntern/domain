package Factory;

import authors.Author;
import book.Article;
import book.Book;
import publishers.Publisher;

public class ArticleFactory {
    public static Book createArticle(int num, int year, String name, Author author, Publisher publisher,String category){
        return new Article.Builder()
                .isbnNum(num)
                .yearPublished(year)
                .title(name)
                .author(author)
                .publisher(publisher)
                .category(category)
                .build();
    }
}
