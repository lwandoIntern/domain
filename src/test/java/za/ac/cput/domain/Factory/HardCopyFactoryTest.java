package za.ac.cput.domain.Factory;

import book.Book;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HardCopyFactoryTest {

    private Book hardCopy;
    @Before
    public void setUp() throws Exception {
        hardCopy = HardCopyFactory.createHardCopy(false);
    }

    @Test
    public void createHardCopy() {
        Assert.assertEquals(hardCopy.getAuthor(),hardCopy.getAuthor());
    }
}