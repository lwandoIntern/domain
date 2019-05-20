package za.ac.cput.domain.services.publisher.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.domain.publisher.Publisher;
import za.ac.cput.domain.repository.publisher.impl.PublisherRepoImpl;
import za.ac.cput.domain.services.publisher.PublisherService;

@Service
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    private PublisherRepoImpl repository;

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
