package book;

import authors.Author;
import publishers.Publisher;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;


@Entity
public class Book {
    @Id
    private String isbnNum;
    private int yearPublished;
    private String title;
    private Author author;
    private Publisher publisher;
    private String category;

    private Book(){}
    public Book(Builder builder){
        this.isbnNum = builder.isbnNum;
        this.yearPublished = builder.yearPublished;
        this.title = builder.title;
        this.author = builder.author;
        this.publisher = builder.publisher;
        this.category = builder.category;
    }

    public String getIsbnNum() {
        return isbnNum;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public String getCategory() {
        return category;
    }

    public static class Builder{
        public String isbnNum;
        private int yearPublished;
        private String title;
        private Author author;
        private Publisher publisher;
        private String category;

        public Builder isbnNum(String num){
            this.isbnNum = num;
            return this;
        }
        public Builder yearPublished(int year){
            this.yearPublished = year;
            return this;
        }
        public Builder title(String title){
            this.title = title;
            return this;
        }
        public Builder author(Author author){
            this.author = author;
            return this;
        }
        public Builder publisher(Publisher publisher){
            this.publisher = publisher;
            return this;
        }
        public Builder category(String v){
            this.category = v;
            return this;
        }
        public Book build(){
            return new Book(this);
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbnNum='" + isbnNum + '\'' +
                ", yearPublished=" + yearPublished +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", publisher=" + publisher +
                ", category='" + category + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return isbnNum.equals(book.isbnNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbnNum);
    }
}
