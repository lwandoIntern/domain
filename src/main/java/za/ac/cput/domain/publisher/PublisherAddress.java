package za.ac.cput.domain.publisher;

import java.util.Objects;

public class PublisherAddress {
    private String publisherId,addressId;

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
