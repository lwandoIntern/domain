package za.ac.cput.domain.repository.publisherRepository;

import publishers.Publisher;
import za.ac.cput.domain.repository.Repository;

import java.util.Map;

public interface PublisherRepository extends Repository<Publisher,String> {
    Publisher findById(String s);
}
