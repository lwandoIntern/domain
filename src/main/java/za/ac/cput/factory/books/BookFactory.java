package za.ac.cput.factory.books;

import za.ac.cput.domain.books.Book;
import za.ac.cput.util.Helper;

import java.util.Date;

public class BookFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(BookFactory.class);
    public static Book createBook(String title, int edition, Date datePublished){
        String id = Helper.generateRandomGivenSuffix(SUFFIX);
        return new Book.Builder()
                .isbn(id)
                .title(title)
                .editionNum(edition)
                .yearPublished(datePublished)
                .build();
    }
}
