package za.ac.cput.domain.request;

/**
 * this class is a combination class
 * It combines the Author, Address, Gender, Race and Book class as they partially or completely
 * form part of the author's true attributes
 *
 */
public class NewAuthor {
    private String authorEmail,firstName,lastName,gender,race,address,book;
    private int numOfBooks;

    public NewAuthor(String authorEmail, String firstName, String lastName, String gender, String race, String address, String book, int numOfBooks) {
        this.authorEmail = authorEmail;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.race = race;
        this.address = address;
        this.book = book;
        this.numOfBooks = numOfBooks;
    }

    public int getNumOfBooks() {
        return numOfBooks;
    }

    public void setNumOfBooks(int numOfBooks) {
        this.numOfBooks = numOfBooks;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "NewAuthor{" +
                "authorId='" + authorEmail + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", race='" + race + '\'' +
                ", address='" + address + '\'' +
                ", book='" + book + '\'' +
                ", numOfBooks=" + numOfBooks +
                '}';
    }
}
