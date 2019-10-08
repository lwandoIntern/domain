package za.ac.cput.factory.books;

import za.ac.cput.domain.books.Book;
import za.ac.cput.util.Helper;

import java.util.Date;

public class BookFactory {

    public static Book createBook(String title, int edition, Date datePublished){

        return new Book.Builder()
                .title(title)
                .editionNum(edition)
                .yearPublished(datePublished)
                .build();
    }
}
