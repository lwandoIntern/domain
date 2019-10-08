package za.ac.cput.factory.author;

import za.ac.cput.domain.author.AuthorRace;

public class AuthorRaceFactory {
    public static AuthorRace buildAuthorRace(String authorId, String raceId){
        return new AuthorRace(authorId,raceId);
    }
}
