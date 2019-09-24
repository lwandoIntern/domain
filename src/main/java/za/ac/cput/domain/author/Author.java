package za.ac.cput.domain.author;

import java.util.Objects;

public class Author {
    private String authorEmail;
    private String firstName;
    private String lastName;
    private int numOfBooksWritten;

    public Author(Builder builder) {
        this.authorEmail = builder.authorId;
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
        return authorEmail.equals(author.authorEmail);
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
        private String authorId;
        private String firstName;
        private String lastName;
        private int numOfBooksWritten;

        public Builder authorId(String s){
            this.authorId = s;
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
