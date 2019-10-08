package za.ac.cput.domain.publisher;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class PublisherAddress {
    @Id
    @Column(name = "publisher_id",nullable = false,columnDefinition = "VARCHAR(20)")
    private String publisherId;
    private String addressId;

    public PublisherAddress(String publisherId, String addressId) {
        this.publisherId = publisherId;
        this.addressId = addressId;
    }

    public String getPublisherId() {
        return publisherId;
    }

    public String getAddressId() {
        return addressId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PublisherAddress that = (PublisherAddress) o;
        return publisherId == that.publisherId &&
                addressId == that.addressId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(publisherId);
    }
}
