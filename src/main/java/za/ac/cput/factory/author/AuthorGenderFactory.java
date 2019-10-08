package za.ac.cput.factory.author;

import za.ac.cput.domain.author.AuthorGender;

public class AuthorGenderFactory {
    public static AuthorGender buildAuthorGender(String authorId, int genderId){
        return new AuthorGender(authorId,genderId);
    }
}
