package model;

public class Book {
    private String isbn;
    private String title,author,edition;
    private int yearPublished;


    private Book(){}
    public Book(Builder builder){
        this.isbn = builder.isbn;
        this.title = builder.title;
        this.author = builder.author;
        this.edition = builder.edition;
        this.yearPublished = builder.yearPublished;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getEdition() {
        return edition;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public static class Builder{
        private String isbn;
        private String title,author,edition;
        private int yearPublished;



        public Builder isbn(String value){
            this.isbn = value;
            return this;
        }
        public Builder title(String value){
            this.title = value;
            return this;
        }
        public Builder author(String value){
            this.author = value;
            return this;
        }
        public Builder edition(String value){
            this.edition = value;
            return this;
        }
        public Builder yearPublished(int value){
            this.yearPublished = value;
            return this;
        }
        public Builder copy(Book book){
            this.isbn = book.isbn;
            this.title = book.title;
            this.author = book.author;
            this.edition = book.edition;
            this.yearPublished = book.yearPublished;
            return this;
        }
        public Book build(){
            return new Book(this);
        }

    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", edition='" + edition + '\'' +
                ", yearPublished=" + yearPublished +
                '}';
    }
}
