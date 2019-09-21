package za.ac.cput.repository.publisher;

import za.ac.cput.domain.publisher.Publisher;
import za.ac.cput.repository.IRepository;

public interface PublisherRepository extends IRepository<Publisher,String> {
    Publisher getByName(String name);
}
