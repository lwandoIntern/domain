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
    public Publisher getByName(String name) {
        return this.publisherRepository.findAll().stream()
                .filter(publisher -> publisher.getName().equalsIgnoreCase(name))
                .findAny()
                .get();
    }

    @Override
    public Publisher create(Publisher publisher) {
        return this.publisherRepository.save(publisher);
    }

    @Override
    public Publisher read(String s) {
        return this.publisherRepository.getOne(s);
    }

    @Override
    public Publisher update(Publisher publisher) {
        return this.publisherRepository.save(publisher);
    }

    @Override
    public void delete(String s) {
        this.publisherRepository.deleteById(s);
    }

    @Override
    public Set<Publisher> getAll() {
        Set set = new HashSet();
        set.addAll(this.publisherRepository.findAll());
        return set;
    }
}
