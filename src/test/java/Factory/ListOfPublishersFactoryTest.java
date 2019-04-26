package Factory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import publishers.ListOfPublishers;
import publishers.Publisher;

import java.util.ArrayList;

public class ListOfPublishersFactoryTest {

    private ListOfPublishers listOfPublishers;
    private ArrayList<Publisher> publishers;
    @Before
    public void setUp() throws Exception {
        listOfPublishers = ListOfPublishersFactory.createPublisherList(publishers);
    }

    @Test
    public void createPublisherList() {
        Assert.assertEquals(listOfPublishers,listOfPublishers);
    }
}