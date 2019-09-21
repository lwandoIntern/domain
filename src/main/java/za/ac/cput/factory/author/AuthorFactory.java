package za.ac.cput.factory.author;

import za.ac.cput.domain.author.Author;
import za.ac.cput.util.Helper;

public class AuthorFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(AuthorFactory.class); // Expecting GF from (G)ender(F)actory.
    public static Author createAuthor(String name,String lastName,int booksWritten){
        String id = Helper.generateRandomGivenSuffix(SUFFIX);
        return new Author.Builder()
                .authorId(id)
                .firstName(name)
                .lastName(lastName)
                .numOfBooksWritten(booksWritten)
                .build();
    }
}
