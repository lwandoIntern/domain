package za.ac.cput.domain.Factory;

import authors.Author;
import book.Book;
import publishers.Publisher;

public class PublisherFactory {
    public static Publisher createPublisher(Author author, Book book,String name,String tel,int zip,String suburb,String city,String province){
        return new Publisher.Builder()
                .author(author)
                .book(book)
                .name(name)
                .telephone(tel)
                .zipCode(zip)
                .suburb(suburb)
                .city(city)
                .province(province)
                .build();
    }
}
