package za.ac.cput.factory.author;

import za.ac.cput.domain.author.AuthorBook;

public class AuthorBookFactory {
    public static AuthorBook createAuthorBook(String authorId,String isbn){
        return new AuthorBook(authorId,isbn);
    }
}
