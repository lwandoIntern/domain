package za.ac.cput.repository.publisher.impl;

import za.ac.cput.domain.publisher.PublisherAddress;
import za.ac.cput.repository.publisher.PublisherAddressRepository;

import java.util.HashSet;
import java.util.Set;

public class PublisherAddressRepositoryImpl implements PublisherAddressRepository {
    private static PublisherAddressRepository publisherAddressRepository = null;
    private Set<PublisherAddress> publisherAddresses;

    private PublisherAddressRepositoryImpl(){
        this.publisherAddresses = new HashSet<>();
    }

    public static PublisherAddressRepository getPublisherAddressRepository() {
        if (publisherAddressRepository == null)publisherAddressRepository = new PublisherAddressRepositoryImpl();
        return publisherAddressRepository;
    }

    private PublisherAddress findPublishersAddress(String pubId){
        return this.publisherAddresses.stream()
                .filter(publisherAddress -> publisherAddress.getPublisherId().trim().equalsIgnoreCase(pubId))
                .findAny()
                .orElse(null);
    }
    @Override
    public PublisherAddress create(PublisherAddress publisherAddress) {
        this.publisherAddresses.add(publisherAddress);
        return publisherAddress;
    }

    @Override
    public PublisherAddress read(String s) {
        return findPublishersAddress(s);
    }

    @Override
    public PublisherAddress update(PublisherAddress publisherAddress) {
        PublisherAddress toDelete = findPublishersAddress(publisherAddress.getPublisherId());
        if (toDelete != null){
            delete(toDelete.getPublisherId());
            return create(publisherAddress);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        PublisherAddress publisherAddress = findPublishersAddress(s);
        if (publisherAddress != null)
            this.publisherAddresses.remove(publisherAddress);
    }

    @Override
    public Set<PublisherAddress> getAll() {
        return this.publisherAddresses;
    }
}
