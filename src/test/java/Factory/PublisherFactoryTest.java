package Factory;

import model.Publisher;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PublisherFactoryTest {

    private Publisher publisher;
    @Before
    public void setUp() throws Exception {
        publisher = PublisherFactory.createPublisher("555","Oxford","14 Strand Street","0214568897");
    }

    @Test
    public void createPublisher() {
        Assert.assertEquals(publisher.getAddress(),publisher.getAddress());
    }
}