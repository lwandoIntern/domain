package za.ac.cput.factory.author;

import za.ac.cput.domain.author.AuthorDemography;

import java.util.Date;

public class AuthorDemographyFactory {
    public static AuthorDemography createAuthorDemography(String authorEmail, String raceId, String genderId){
        return new AuthorDemography(authorEmail,raceId,genderId);
    }
}
