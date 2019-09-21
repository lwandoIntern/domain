package za.ac.cput.service.publisher;

import za.ac.cput.domain.publisher.Publisher;
import za.ac.cput.service.IService;

public interface PublisherService extends IService<Publisher,String> {
    Publisher getByName(String name);
}
