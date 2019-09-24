package za.ac.cput.factory.author;

import za.ac.cput.domain.author.AuthorGender;

public class AuthorGenderFactory {
    public static AuthorGender buildAuthorGender(String authorEmail,String genderId){
        return new AuthorGender(authorEmail,genderId);
    }
}
