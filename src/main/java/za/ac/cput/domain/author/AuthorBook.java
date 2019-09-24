package za.ac.cput.domain.author;

import java.util.Objects;

public class AuthorBook {
    private String authorEmail,isbn;

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
