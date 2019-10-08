package za.ac.cput.domain.author;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
@Entity
public class Author {
    @Id
    @Column(name = "author_email",nullable = false,columnDefinition = "VARCHAR(100)")
    private String authorEmail;
    private String firstName;
    private String lastName;
    private int numOfBooksWritten;

    public Author(Builder builder) {
        this.authorEmail = builder.authorEmail;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.numOfBooksWritten = builder.numOfBooksWritten;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getNumOfBooksWritten() {
        return numOfBooksWritten;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return authorEmail ==author.authorEmail;
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorEmail);
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId='" + authorEmail + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", numOfBooksWritten=" + numOfBooksWritten +
                '}';
    }
    public static class Builder{
        private String authorEmail;
        private String firstName;
        private String lastName;
        private int numOfBooksWritten;

        public Builder authorEmail(String s){
            this.authorEmail = s;
            return this;
        }
        public Builder firstName(String nm){
            this.firstName = nm;
            return this;
        }
        public Builder lastName(String lnm){
            this.lastName = lnm;
            return this;
        }
        public Builder numOfBooksWritten(int numBooks){
            this.numOfBooksWritten = numBooks;
            return this;
        }
        public Author build(){
            return new Author(this);
        }
    }
}
