package za.ac.cput.service.publisher.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.publisher.Publisher;
import za.ac.cput.repository.publisher.PublisherRepository;
import za.ac.cput.repository.publisher.impl.PublisherRepositoryImpl;
import za.ac.cput.service.publisher.PublisherService;

import java.util.Set;

@Service
public class PublisherServiceImpl implements PublisherService {
    private static PublisherService publisherService = null;
    private PublisherRepository publisherRepository;

    private PublisherServiceImpl(){
        this.publisherRepository = PublisherRepositoryImpl.getPublisherRepository();
    }
    @Override
    public Publisher create(Publisher publisher) {
        return this.publisherRepository.create(publisher);
    }

    @Override
    public Publisher read(String s) {
        return this.publisherRepository.read(s);
    }

    @Override
    public Publisher update(Publisher publisher) {
        return this.publisherRepository.update(publisher);
    }

    @Override
    public void delete(String s) {
        this.publisherRepository.delete(s);
    }

    @Override
    public Set<Publisher> getAll() {
        return this.publisherRepository.getAll();
    }

    @Override
    public Publisher getByName(String name) {
        return this.publisherRepository.getByName(name);
    }
}
