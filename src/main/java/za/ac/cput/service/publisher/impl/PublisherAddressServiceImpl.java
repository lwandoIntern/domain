package za.ac.cput.service.publisher.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.publisher.PublisherAddress;
import za.ac.cput.repository.publisher.PublisherAddressRepository;
import za.ac.cput.service.publisher.PublisherAddressService;


import java.util.HashSet;
import java.util.Set;

@Service
public class PublisherAddressServiceImpl implements PublisherAddressService {
    private static PublisherAddressService publisherAddressService = null;
    @Autowired
    private PublisherAddressRepository publisherAddressRepository;

    private PublisherAddressServiceImpl(){}

    public static PublisherAddressService getPublisherAddressService() {
        if (publisherAddressService == null)publisherAddressService = new PublisherAddressServiceImpl();
        return publisherAddressService;
    }

    @Override
    public PublisherAddress create(PublisherAddress publisherAddress) {
        this.publisherAddressRepository.save(publisherAddress);
        return this.publisherAddressRepository.getOne(publisherAddress.getPublisherId());
    }

    @Override
    public PublisherAddress read(String s) {
        return this.publisherAddressRepository.getOne(s);
    }

    @Override
    public PublisherAddress update(PublisherAddress publisherAddress) {
        PublisherAddress toDelete = read(publisherAddress.getPublisherId());
        if (toDelete == publisherAddress){
            delete(toDelete.getPublisherId());
            return create(publisherAddress);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        if (read(s) != null)
            this.publisherAddressRepository.deleteById(s);
    }

    @Override
    public Set<PublisherAddress> getAll() {
        Set<PublisherAddress> publisherAddresses = new HashSet<>();
        publisherAddresses.addAll(this.publisherAddressRepository.findAll());
        return publisherAddresses;
    }
}
