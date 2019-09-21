package za.ac.cput.repository.publisher.impl;

import za.ac.cput.domain.publisher.Publisher;
import za.ac.cput.repository.publisher.PublisherRepository;

import java.util.HashSet;
import java.util.Set;

public class PublisherRepositoryImpl implements PublisherRepository {
    private static PublisherRepository publisherRepository = null;
    private Set<Publisher> publishers;

    private PublisherRepositoryImpl(){
        this.publishers = new HashSet<>();
    }

    public static PublisherRepository getPublisherRepository() {
        if (publisherRepository == null)publisherRepository = new PublisherRepositoryImpl();
        return publisherRepository;
    }

    private Publisher findPublisher(String id){
        return this.publishers.stream()
                .filter(publisher -> publisher.getPublisherId().trim().equalsIgnoreCase(id))
                .findAny()
                .orElse(null);
    }
    @Override
    public Publisher getByName(String name) {
        return this.publishers.stream().filter(publisher -> publisher.getName().equalsIgnoreCase(name))
                .findAny()
                .orElse(null);
    }

    @Override
    public Publisher create(Publisher publisher) {
        this.publishers.add(publisher);
        return create(publisher);
    }

    @Override
    public Publisher read(String s) {
        Publisher publisher = findPublisher(s);
        return publisher;
    }

    @Override
    public Publisher update(Publisher publisher) {
        Publisher toDelete = findPublisher(publisher.getPublisherId());
        if (toDelete != null){
            this.publishers.remove(toDelete);
            return create(publisher);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        Publisher publisher = findPublisher(s);
        if (publisher != null)this.publishers.remove(publisher);
    }

    @Override
    public Set<Publisher> getAll() {
        return this.publishers;
    }
}
