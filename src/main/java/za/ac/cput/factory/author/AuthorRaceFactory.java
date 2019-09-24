package za.ac.cput.factory.author;

import za.ac.cput.domain.author.AuthorRace;

public class AuthorRaceFactory {
    public static AuthorRace buildAuthorRace(String authorEmail,String raceId){
        return new AuthorRace(authorEmail,raceId);
    }
}
