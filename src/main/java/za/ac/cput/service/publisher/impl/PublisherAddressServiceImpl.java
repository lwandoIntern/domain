package za.ac.cput.service.publisher.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.publisher.PublisherAddress;
import za.ac.cput.repository.publisher.PublisherAddressRepository;
import za.ac.cput.repository.publisher.impl.PublisherAddressRepositoryImpl;
import za.ac.cput.service.publisher.PublisherAddressService;

import java.util.Set;

@Service
public class PublisherAddressServiceImpl implements PublisherAddressService {
    private static PublisherAddressService publisherAddressService = null;
    private PublisherAddressRepository publisherAddressRepository;

    private PublisherAddressServiceImpl(){
        this.publisherAddressRepository = PublisherAddressRepositoryImpl.getPublisherAddressRepository();
    }

    public static PublisherAddressService getPublisherAddressService() {
        if (publisherAddressService == null)publisherAddressService = new PublisherAddressServiceImpl();
        return publisherAddressService;
    }

    @Override
    public PublisherAddress create(PublisherAddress publisherAddress) {
        return publisherAddressRepository.create(publisherAddress);
    }

    @Override
    public PublisherAddress read(String s) {
        return this.publisherAddressRepository.read(s);
    }

    @Override
    public PublisherAddress update(PublisherAddress publisherAddress) {
        return this.publisherAddressRepository.update(publisherAddress);
    }

    @Override
    public void delete(String s) {
        this.publisherAddressRepository.delete(s);
    }

    @Override
    public Set<PublisherAddress> getAll() {
        return this.publisherAddressRepository.getAll();
    }
}
