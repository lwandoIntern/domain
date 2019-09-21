package za.ac.cput.domain.books;

import java.util.Objects;

public class BookPublisher {
    private String isbn,publisherId;

    public BookPublisher(String isbn, String publisherId) {
        this.isbn = isbn;
        this.publisherId = publisherId;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPublisherId() {
        return publisherId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookPublisher that = (BookPublisher) o;
        return isbn.equals(that.isbn) &&
                publisherId.equals(that.publisherId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, publisherId);
    }
}
