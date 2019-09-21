package za.ac.cput.domain.author;

import java.util.Date;
import java.util.Objects;

public class AuthorDemography {
    private String authorId,raceId,genderId;

    private AuthorDemography(){}
    public AuthorDemography(String authorId, String raceId, String genderId) {
        this.authorId = authorId;
        this.raceId = raceId;
        this.genderId = genderId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public String getRaceId() {
        return raceId;
    }

    public String getGenderId() {
        return genderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorDemography that = (AuthorDemography) o;
        return authorId.equals(that.authorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId);
    }

    @Override
    public String toString() {
        return "AuthorDemography{" +
                "authorId='" + authorId + '\'' +
                ", raceId='" + raceId + '\'' +
                ", genderId='" + genderId + '\'' +
                '}';
    }
}
