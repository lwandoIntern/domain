package za.ac.cput.domain.books;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
public class Book {
    @Id
    @Column(name = "isbn_number")
    private String isbn;
    @Column(name = "book_title")
    private String title;
    @Column(name = "edition")
    private int editionNum;
    @Column(name = "year_published")
    private Date yearPublished;


    private Book(){}
    public Book(Builder builder) {
        this.isbn = builder.isbn;
        this.title = builder.title;
        this.editionNum = builder.editionNum;
        this.yearPublished = builder.yearPublished;

    }


    public Date getYearPublished() {
        return yearPublished;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public int getEditionNum() {
        return editionNum;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", editionNum=" + editionNum +
                ", yearPublished=" + yearPublished +
                '}';
    }
    public static class Builder{
        private String isbn,title;
        private int editionNum;
        private Date yearPublished;
        public Builder isbn(String isbn){
            this.isbn = isbn;
            return this;
        }
        public Builder title(String s){
            this.title = s;
            return this;
        }
        public Builder editionNum(int editionNum){
            this.editionNum = editionNum;
            return this;
        }
        public Builder yearPublished(Date yearPublished){
            this.yearPublished = yearPublished;
            return this;
        }
        public Book build(){
            return new Book(this);
        }
    }
}
