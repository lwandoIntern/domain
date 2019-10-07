package za.ac.cput.service.publisher.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.publisher.Publisher;
import za.ac.cput.repository.publisher.PublisherRepository;
import za.ac.cput.service.publisher.PublisherService;


import java.util.HashSet;
import java.util.Set;

@Service
public class PublisherServiceImpl implements PublisherService {
    private static PublisherService publisherService = null;
    @Autowired
    private PublisherRepository publisherRepository;

    private PublisherServiceImpl(){}

    public static PublisherService getPublisherService() {
        if (publisherService == null)publisherService = new PublisherServiceImpl();
        return publisherService;
    }

    @Override
    public Publisher create(Publisher publisher) {
        this.publisherRepository.save(publisher);
        return this.publisherRepository.getOne(publisher.getPublisherId());
    }

    @Override
    public Publisher read(String s) {
        return this.publisherRepository.getOne(s);
    }

    @Override
    public Publisher update(Publisher publisher) {
        Publisher publisher1 = read(publisher.getPublisherId());
        if (publisher1 == publisher){
            delete(publisher1.getPublisherId());
            return create(publisher);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        if (read(s) != null)
            this.publisherRepository.deleteById(s);
    }

    @Override
    public Set<Publisher> getAll() {
        Set<Publisher> publishers = new HashSet<>();
        publishers.addAll(this.publisherRepository.findAll());
        return publishers;
    }

    @Override
    public Publisher getByName(String name) {
        return getAll().stream()
                .filter(publisher -> publisher.getName().equalsIgnoreCase(name))
                .findAny()
                .get();
    }
}
