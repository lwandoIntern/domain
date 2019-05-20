package za.ac.cput.domain.Factory.publisher;

import za.ac.cput.domain.domain.publisher.ListOfPublishers;
import za.ac.cput.domain.domain.publisher.Publisher;

import java.util.ArrayList;

public class ListOfPublishersFactory {
    public static ListOfPublishers createPublisherList(ArrayList<Publisher> publishers){
        return new ListOfPublishers.Builder()
                .publishers(publishers)
                .build();
    }
}
