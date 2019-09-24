package za.ac.cput.factory.author;

import za.ac.cput.domain.author.Author;
import za.ac.cput.util.Helper;

public class AuthorFactory {

    public static Author createAuthor(String email,String name,String lastName,int booksWritten){
        return new Author.Builder()
                .authorId(email)
                .firstName(name)
                .lastName(lastName)
                .numOfBooksWritten(booksWritten)
                .build();
    }
}
