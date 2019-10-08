package za.ac.cput.domain.books;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class BookPublisher {
    @Id
    @Column(name = "isbn_number",nullable = false,columnDefinition = "VARCHAR(20)")
    private String isbn;
    private String publisherId;

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
        return isbn == that.isbn &&
                publisherId == that.publisherId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, publisherId);
    }
}
