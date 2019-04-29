package za.ac.cput.domain.Factory.books;

import za.ac.cput.domain.domain.authors.Author;
import za.ac.cput.domain.domain.book.Article;
import za.ac.cput.domain.domain.book.Book;
import za.ac.cput.domain.domain.publishers.Publisher;

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
