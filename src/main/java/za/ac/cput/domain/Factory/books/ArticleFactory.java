package za.ac.cput.domain.Factory.books;

import za.ac.cput.domain.domain.authors.Author;
import za.ac.cput.domain.domain.book.Article;
import za.ac.cput.domain.domain.book.Book;
import za.ac.cput.domain.domain.publisher.Publisher;
import za.ac.cput.domain.util.Misc;

public class ArticleFactory {
    public static Book createArticle(int year, String name, Author author, Publisher publisher,String category){
        return new Article.ArticleBuilder()
                .isbnNum(Misc.generateId())
                .yearPublished(year)
                .title(name)
                .author(author)
                .publisher(publisher)
                .category(category)
                .build();
    }
    public static Book firstArticle(String title,int year){
        return new Article.ArticleBuilder()
                .isbnNum(Misc.generateId())
                .yearPublished(year)
                .title(title)
                .build();
    }
}
