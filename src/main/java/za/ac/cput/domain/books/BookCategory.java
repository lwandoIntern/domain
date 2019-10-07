package za.ac.cput.domain.books;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class BookCategory implements Serializable {
    @Id
    @Column(name = "category_id")
    private String categoryId;
    @Id
    @Column(name = "isbn_number")
    private String isbn;

    private BookCategory(){}
    public BookCategory(String categoryId, String isbn) {
        this.categoryId = categoryId;
        this.isbn = isbn;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookCategory that = (BookCategory) o;
        return categoryId.equals(that.categoryId) &&
                isbn.equals(that.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, isbn);
    }
}
