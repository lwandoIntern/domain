package za.ac.cput.domain.repository.publisher;

import za.ac.cput.domain.domain.publisher.Publisher;
import za.ac.cput.domain.repository.Repository;

public interface PublisherRepository extends Repository<Publisher,String> {
    Publisher findById(String s);
}
