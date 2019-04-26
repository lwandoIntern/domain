package Factory;

import employees.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LibrarianFactoryTest {

    private Employee librarian;
    @Before
    public void setUp() throws Exception {
        librarian = LibrarianFactory.createLibrarian(false);
    }

    @Test
    public void createLibrarian() {
        Assert.assertNotNull(librarian);
    }
}