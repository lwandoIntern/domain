package za.ac.cput.domain.author;

import java.util.Objects;

public class AuthorGender {
    private String authorId,genderId;

    public AuthorGender(String authorId, String genderId) {
        this.authorId = authorId;
        this.genderId = genderId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public String getGenderId() {
        return genderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorGender that = (AuthorGender) o;
        return Objects.equals(authorId, that.authorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId);
    }

    @Override
    public String toString() {
        return "AuthorGender{" +
                "authorId='" + authorId + '\'' +
                ", genderId='" + genderId + '\'' +
                '}';
    }
}
