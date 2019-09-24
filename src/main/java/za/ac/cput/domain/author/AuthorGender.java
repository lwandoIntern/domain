package za.ac.cput.domain.author;

import java.util.Objects;

public class AuthorGender {
    private String authorEmail,genderId;

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
