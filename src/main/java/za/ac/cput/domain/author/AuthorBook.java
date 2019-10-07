package za.ac.cput.domain.author;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;


@Entity
public class AuthorBook implements Serializable {
    @Id
    @Column(name = "email")
    private String authorEmail;
    @Id
    @Column(name = "isbn_number")
    private String isbn;


    private AuthorBook(){}
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
        return authorEmail.equals(that.authorEmail) &&
                isbn.equals(that.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorEmail, isbn);
    }
}
