package book;

import authors.Author;
import publishers.Publisher;

import java.util.Objects;

public class HardCopy implements Book{
    private boolean availableForLoan;
    private String isbnNum,title,category,condition;
    private Author author;
    private Publisher publisher;
    private int yearPublished;

    private HardCopy(){}
    public HardCopy(Builder builder){
        this.isbnNum = builder.isbnNum;
        this.title = builder.title;
        this.category = builder.category;
        this.author = builder.author;
        this.publisher = builder.publisher;
        this.condition = builder.condition;
        this.availableForLoan = builder.availableForLoan;
        this.yearPublished = builder.yearPublished;
    }

    public static class Builder {
        private boolean availableForLoan;
        private String isbnNum,title,category,condition;
        private Author author;
        private Publisher publisher;
        private int yearPublished;

        Builder isbnNum(String id){
            this.isbnNum = id;
            return this;
        }
        Builder title(String tit){
            this.title = tit;
            return this;
        }
        Builder category(String cat){
            this.category = cat;
            return this;
        }
        Builder condition(String condition){
            this.condition = condition;
            return this;
        }
        Builder author(Author author){
            this.author = author;
            return this;
        }
        Builder publisher(Publisher publisher){
            this.publisher = publisher;
            return this;
        }
        Builder availableForLoan(boolean loan){
            this.availableForLoan = loan;
            return this;
        }
        Builder yearPublished(int yearPublished){
            this.yearPublished = yearPublished;
            return this;
        }
        HardCopy build(){
            return new HardCopy(this);
        }
    }

    @Override
    public String getIsbnNum() {
        return isbnNum;
    }

    @Override
    public int getYearPublished() {
        return yearPublished;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public Author getAuthor() {
        return author;
    }

    @Override
    public Publisher getPublisher() {
        return publisher;
    }

    @Override
    public String getCategory() {
        return category;
    }

    public boolean isAvailableForLoan() {
        return availableForLoan;
    }

    public String getCondition() {
        return condition;
    }

    @Override
    public String toString() {
        return "HardCopy{" +
                "availableForLoan=" + availableForLoan +
                ", isbnNum='" + isbnNum + '\'' +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", condition='" + condition + '\'' +
                ", author=" + author +
                ", publisher=" + publisher +
                ", yearPublished=" + yearPublished +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HardCopy hardCopy = (HardCopy) o;
        return availableForLoan == hardCopy.availableForLoan;
    }

    @Override
    public int hashCode() {
        return Objects.hash(availableForLoan);
    }
}
