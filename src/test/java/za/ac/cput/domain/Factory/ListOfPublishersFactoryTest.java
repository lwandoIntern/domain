package za.ac.cput.domain.Factory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.domain.Factory.publisher.ListOfPublishersFactory;
import za.ac.cput.domain.domain.publishers.ListOfPublishers;
import za.ac.cput.domain.domain.publishers.Publisher;

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