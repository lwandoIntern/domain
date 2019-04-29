package za.ac.cput.domain.repository.publisherRepository;

import za.ac.cput.domain.domain.publishers.Publisher;
import za.ac.cput.domain.repository.Repository;

public interface PublisherRepository extends Repository<Publisher,String> {
    Publisher findById(String s);
}
