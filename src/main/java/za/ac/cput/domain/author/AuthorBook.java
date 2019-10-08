package za.ac.cput.domain.author;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class AuthorBook {
    @Id
    @Column(name = "author_email",nullable = false,columnDefinition = "VARCHAR(100)")
    private String authorEmail;
    private String isbn;

    public AuthorBook(String authorEmail, String isbn) {
        this.authorEmail = authorEmail;
        this.isbn = isbn;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorBook that = (AuthorBook) o;
        return authorEmail == that.authorEmail &&
                isbn == that.isbn;
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorEmail, isbn);
    }
}
