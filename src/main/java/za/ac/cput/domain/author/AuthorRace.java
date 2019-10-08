package za.ac.cput.domain.author;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class AuthorRace {
    @Id
    @Column(name = "author_email",nullable = false,columnDefinition = "VARCHAR(100)")
    private String authorEmail;
    private String raceId;

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
        return Objects.equals(authorEmail, that.authorEmail) &&
                Objects.equals(raceId, that.raceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorEmail);
    }
}
