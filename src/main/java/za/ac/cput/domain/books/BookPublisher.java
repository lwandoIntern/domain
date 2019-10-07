package za.ac.cput.domain.books;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class BookPublisher implements Serializable {
    @Id
    @Column(name = "isbn_number")
    private String isbn;
    @Id
    @Column(name = "publisher_id")
    private String publisherId;


    private BookPublisher(){}
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
