package za.ac.cput.domain.author;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class AuthorAddress {
    @Id
    @Column(name = "author_email",nullable = false,columnDefinition = "VARCHAR(100)")
    private String authorEmail;
    private String addressId;

    public AuthorAddress(String authorEmail, String addressId) {
        this.authorEmail = authorEmail;
        this.addressId = addressId;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public String getAddressId() {
        return addressId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorAddress that = (AuthorAddress) o;
        return authorEmail == that.authorEmail &&
                addressId == that.addressId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorEmail, addressId);
    }
}
