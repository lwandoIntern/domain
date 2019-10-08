package za.ac.cput.factory.publisher;

import za.ac.cput.domain.publisher.Publisher;
import za.ac.cput.util.Helper;

public class PublisherFactory {

    public static Publisher createPublisher(String name){

        return new Publisher.Builder()

                .name(name)
                .build();
    }
}
