package za.ac.cput.domain.repository.publisherRepository.impl;


import publishers.Publisher;

import za.ac.cput.domain.repository.publisherRepository.PublisherRepository;

import java.util.HashMap;
import java.util.Map;

public class PublisherRepoImpl implements PublisherRepository {
    private static PublisherRepoImpl repo = null;
    private Map<String,Publisher> publishers;

    private PublisherRepoImpl(){
        publishers = new HashMap<>();
    }

    public static PublisherRepoImpl getRepo() {
        if (repo == null)repo = new PublisherRepoImpl();
        return repo;
    }

    @Override
    public Publisher findById(String s) {
        return repo.publishers.get(s);
    }

    @Override
    public Publisher create(Publisher publisher) {
        return repo.publishers.put(publisher.getPublishId(),publisher);
    }

    @Override
    public Publisher read(Publisher publisher) {
        return repo.publishers.get(publisher);
    }

    @Override
    public Publisher update(Publisher publisher) {
        return repo.publishers.put(publisher.getPublishId(),publisher);
    }

    @Override
    public void delete(String s) {
        repo.publishers.remove(s);
    }
}
