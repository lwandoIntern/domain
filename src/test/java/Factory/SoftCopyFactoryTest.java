package Factory;

import book.Book;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SoftCopyFactoryTest {

    private Book softCopy;
    @Before
    public void setUp() throws Exception {
        softCopy = SoftCopyFactory.createSoftCopy(false);
    }

    @Test
    public void createSoftCopy() {
        Assert.assertEquals(softCopy.getAuthor(),softCopy.getAuthor());
    }
}