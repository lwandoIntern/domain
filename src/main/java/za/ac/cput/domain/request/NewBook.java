package za.ac.cput.domain.request;

import java.util.Date;

public class NewBook {
    private String isbn;
    private String bookTitle;
    private String categoryName;
    private String publisherName;
    private String fullname;
    private int editionNumber;
    private Date yearPublished;

    public NewBook(String isbn, String bookTitle, String categoryName, String publisherName, String fullname, int editionNumber, Date yearPublished) {
        this.isbn = isbn;
        this.bookTitle = bookTitle;
        this.categoryName = categoryName;
        this.publisherName = publisherName;
        this.fullname = fullname;
        this.editionNumber = editionNumber;
        this.yearPublished = yearPublished;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getEditionNumber() {
        return editionNumber;
    }

    public void setEditionNumber(int editionNumber) {
        this.editionNumber = editionNumber;
    }

    public Date getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(Date yearPublished) {
        this.yearPublished = yearPublished;
    }

    @Override
    public String toString() {
        return "NewBook{" +
                "isbn='" + isbn + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", publisherName='" + publisherName + '\'' +
                ", authorId='" + fullname + '\'' +
                ", editionNumber=" + editionNumber +
                ", yearPublished=" + yearPublished +
                '}';
    }
}
