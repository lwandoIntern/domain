package book;

import authors.Author;
import publishers.Publisher;

public class Book {
    private int isbnNum,yearPublished;
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

    public int getIsbnNum() {
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
        private int isbnNum,yearPublished;
        private String title;
        private Author author;
        private Publisher publisher;
        private String category;

        public Builder isbnNum(int num){
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
        public Builder copy(Book book){
            this.isbnNum = book.isbnNum;
            this.yearPublished = book.yearPublished;
            this.title = book.title;
            this.author = book.author;
            this.publisher = book.publisher;
            this.category = book.category;
            return this;
        }
        public Book build(){
            return new Book(this);
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbnNum=" + isbnNum +
                ", yearPublished=" + yearPublished +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", publisher=" + publisher +
                ", category='" + category + '\'' +
                '}';
    }
}
