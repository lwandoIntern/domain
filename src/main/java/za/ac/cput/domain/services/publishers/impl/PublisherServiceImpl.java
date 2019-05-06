package za.ac.cput.domain.services.publishers.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.domain.publishers.Publisher;
import za.ac.cput.domain.repository.publisherRepository.PublisherRepository;
import za.ac.cput.domain.repository.publisherRepository.impl.PublisherRepoImpl;
import za.ac.cput.domain.services.publishers.PublisherService;

@Service
public class PublisherServiceImpl implements PublisherService {

    private static PublisherServiceImpl service = null;
    private PublisherRepoImpl repository;

    private PublisherServiceImpl(){
        this.repository = PublisherRepoImpl.getRepo();
    }
    public static PublisherServiceImpl getService(){
        if (service == null)service = new PublisherServiceImpl();
        return service;
    }
    @Override
    public Publisher create(Publisher publisher) {
        return this.repository.create(publisher);
    }

    @Override
    public Publisher update(Publisher publisher) {
        return this.repository.update(publisher);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Publisher read(Publisher publisher) {
        return this.repository.read(publisher);
    }
}
