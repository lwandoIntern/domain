package za.ac.cput.domain.publisher;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;


@Entity
public class PublisherAddress implements Serializable {
    @Id
    @Column(name = "publisher_id")
    private String publisherId;
    @Id
    @Column(name = "address_id")
    private String addressId;

    private PublisherAddress(){}
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
        return publisherId.equals(that.publisherId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publisherId);
    }
}
