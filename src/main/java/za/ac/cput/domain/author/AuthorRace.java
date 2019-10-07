package za.ac.cput.domain.author;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class AuthorRace implements Serializable {
    @Id
    @Column(name = "email")
    private String authorEmail;
    @Id
    @Column(name = "race_id")
    private String raceId;


    private AuthorRace(){}
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
