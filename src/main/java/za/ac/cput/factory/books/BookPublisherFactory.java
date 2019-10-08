package za.ac.cput.factory.books;

import za.ac.cput.domain.books.BookPublisher;

public class BookPublisherFactory{
    public static BookPublisher createBookPublisher(String isbn, String publisherId){
        return new BookPublisher(isbn,publisherId);
    }
}
