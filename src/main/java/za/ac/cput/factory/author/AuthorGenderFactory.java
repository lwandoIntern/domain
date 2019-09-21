package za.ac.cput.factory.author;

import za.ac.cput.domain.author.AuthorGender;

public class AuthorGenderFactory {
    public static AuthorGender buildAuthorGender(String authorId,String genderId){
        return new AuthorGender(authorId,genderId);
    }
}
