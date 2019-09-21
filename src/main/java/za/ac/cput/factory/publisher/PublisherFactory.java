package za.ac.cput.factory.publisher;

import za.ac.cput.domain.publisher.Publisher;
import za.ac.cput.util.Helper;

public class PublisherFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(PublisherFactory.class);
    public static Publisher createPublisher(String name){
        String id = Helper.generateRandomGivenSuffix(SUFFIX);
        return new Publisher.Builder()
                .publisherId(id)
                .name(name)
                .build();
    }
}
