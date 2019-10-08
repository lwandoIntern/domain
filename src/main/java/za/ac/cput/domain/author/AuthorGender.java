package za.ac.cput.domain.author;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class AuthorGender {
    @Id
    @Column(name = "author_email",nullable = false,columnDefinition = "VARCHAR(100)")
    private String authorEmail;
    private int genderId;

    public AuthorGender(String authorEmail, int genderId) {
        this.authorEmail = authorEmail;
        this.genderId = genderId;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public int getGenderId() {
        return genderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorGender that = (AuthorGender) o;
        return authorEmail == that.authorEmail &&
                genderId == that.genderId;
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
