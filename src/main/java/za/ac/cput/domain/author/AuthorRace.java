package za.ac.cput.domain.author;

import java.util.Objects;

public class AuthorRace {
    private String authorEmail,raceId;

    public AuthorRace(String authorEmail, String raceId) {
        this.authorEmail = authorEmail;
        this.raceId = raceId;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public String getRaceId() {
        return raceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorRace that = (AuthorRace) o;
        return authorEmail.equals(that.authorEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorEmail);
    }
}
