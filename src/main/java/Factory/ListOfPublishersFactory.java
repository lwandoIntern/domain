package Factory;

import publishers.ListOfPublishers;
import publishers.Publisher;

import java.util.ArrayList;

public class ListOfPublishersFactory {
    public static ListOfPublishers createPublisherList(ArrayList<Publisher> publishers){
        return new ListOfPublishers.Builder()
                .publishers(publishers)
                .build();
    }
}
