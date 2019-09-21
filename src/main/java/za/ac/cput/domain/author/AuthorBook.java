package za.ac.cput.domain.author;

import java.util.Objects;

public class AuthorBook {
    private String authorId,isbn;

    public AuthorBook(String authorId, String isbn) {
        this.authorId = authorId;
        this.isbn = isbn;
    }

    public String getAuthorId() {
        return authorId;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorBook that = (AuthorBook) o;
        return authorId.equals(that.authorId) &&
                isbn.equals(that.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId, isbn);
    }
}
