package za.ac.cput.domain.author;

import java.util.Objects;

public class AuthorDemography {
    private String authorEmail,raceId,genderId;

    private AuthorDemography(){}
    public AuthorDemography(String authorEmail, String raceId, String genderId) {
        this.authorEmail = authorEmail;
        this.raceId = raceId;
        this.genderId = genderId;
    }

    public String getAuthorEmail() {
        return authorEmail;
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
        return authorEmail.equals(that.authorEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorEmail);
    }

    @Override
    public String toString() {
        return "AuthorDemography{" +
                "authorId='" + authorEmail + '\'' +
                ", raceId='" + raceId + '\'' +
                ", genderId='" + genderId + '\'' +
                '}';
    }
}
