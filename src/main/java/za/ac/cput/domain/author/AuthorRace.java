package za.ac.cput.domain.author;

import java.util.Objects;

public class AuthorRace {
    private String authorId,raceId;

    public AuthorRace(String authorId, String raceId) {
        this.authorId = authorId;
        this.raceId = raceId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public String getRaceId() {
        return raceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorRace that = (AuthorRace) o;
        return authorId.equals(that.authorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId);
    }
}
