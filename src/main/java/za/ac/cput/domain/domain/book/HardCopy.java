package za.ac.cput.domain.domain.book;

import za.ac.cput.domain.domain.authors.Author;
import za.ac.cput.domain.domain.publisher.Publisher;

import java.util.Objects;


public class HardCopy implements Book{
    private boolean availableForLoan;
    private String isbnNum,title,category,condition;
    private int yearPublished;

    private HardCopy(){}
    public HardCopy(Builder builder){
        this.isbnNum = builder.isbnNum;
        this.title = builder.title;
        this.category = builder.category;
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

         public Builder isbnNum(String id){
            this.isbnNum = id;
            return this;
        }
        public Builder title(String tit){
            this.title = tit;
            return this;
        }
        public Builder category(String cat){
            this.category = cat;
            return this;
        }
        public Builder condition(String condition){
            this.condition = condition;
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
        public Builder availableForLoan(boolean loan){
            this.availableForLoan = loan;
            return this;
        }
        public Builder yearPublished(int yearPublished){
            this.yearPublished = yearPublished;
            return this;
        }
        public HardCopy build(){
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
