package za.ac.cput.domain.books;

import java.util.Objects;

public class BookCategory {
    private String categoryId,isbn;

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
