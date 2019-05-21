package za.ac.cput.domain.Factory.publisher;

import za.ac.cput.domain.domain.authors.Author;
import za.ac.cput.domain.domain.book.Book;
import za.ac.cput.domain.domain.publisher.Publisher;
import za.ac.cput.domain.util.Misc;

public class PublisherFactory {
    public static Publisher createPublisher(Author author, Book book,String name,String tel,int zip,String suburb,String city,String province){
        return new Publisher.Builder()
                .publishedId(Misc.generateId())
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
    public static Publisher createPubHouse(String name,String tel,int zip){
        return new Publisher.Builder()
                .publishedId(Misc.generateId())
                .name(name)
                .telephone(tel)
                .zipCode(zip)
                .build();
    }
}
