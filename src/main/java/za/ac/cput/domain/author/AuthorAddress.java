package za.ac.cput.domain.author;

import java.util.Objects;

public class AuthorAddress {
    private String authorEmail,addressId;

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
        return authorEmail.equals(that.authorEmail) &&
                addressId.equals(that.addressId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorEmail, addressId);
    }
}
