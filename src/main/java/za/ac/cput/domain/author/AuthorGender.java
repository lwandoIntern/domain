package za.ac.cput.domain.author;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class AuthorGender implements Serializable {
    @Id
    @Column(name = "email")
    private String authorEmail;
    @Id
    @Column(name = "gender_id")
    private String genderId;

    private AuthorGender(){}
    public AuthorGender(String authorEmail, String genderId) {
        this.authorEmail = authorEmail;
        this.genderId = genderId;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public String getGenderId() {
        return genderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorGender that = (AuthorGender) o;
        return Objects.equals(authorEmail, that.authorEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorEmail);
    }

    @Override
    public String toString() {
        return "AuthorGender{" +
                "authorId='" + authorEmail + '\'' +
                ", genderId='" + genderId + '\'' +
                '}';
    }
}
