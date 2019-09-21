package za.ac.cput.domain.author;

import java.util.Objects;

public class AuthorAddress {
    private String authorId,addressId;

    public AuthorAddress(String authorId, String addressId) {
        this.authorId = authorId;
        this.addressId = addressId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public String getAddressId() {
        return addressId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorAddress that = (AuthorAddress) o;
        return authorId.equals(that.authorId) &&
                addressId.equals(that.addressId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId, addressId);
    }
}
