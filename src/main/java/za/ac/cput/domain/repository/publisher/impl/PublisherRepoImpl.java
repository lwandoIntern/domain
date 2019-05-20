package za.ac.cput.domain.repository.publisher.impl;


import org.springframework.stereotype.Repository;
import za.ac.cput.domain.domain.publisher.Publisher;

import za.ac.cput.domain.repository.publisher.PublisherRepository;

import java.util.*;

@Repository
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
        return repo.publishers.get(publisher.getPublishId());
    }

    @Override
    public Publisher update(Publisher publisher) {
        repo.publishers.replace(publisher.getPublishId(),publisher);
        return repo.publishers.get(publisher.getPublishId());
    }

    @Override
    public void delete(String s) {
        repo.publishers.remove(s);
    }


}