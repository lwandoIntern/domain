package za.ac.cput.factory.publisher;

import za.ac.cput.domain.publisher.PublisherAddress;

public class PublisherAddressFactory {
    public static PublisherAddress createPublisherAddress(String publisherId,String addressId){
        return new PublisherAddress(publisherId,addressId);
    }
}
