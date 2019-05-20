package za.ac.cput.domain.Factory;

import za.ac.cput.domain.Factory.employee.LibrarianFactory;
import za.ac.cput.domain.domain.employee.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LibrarianFactoryTest {

    private Employee librarian;
    @Before
    public void setUp() throws Exception {
        librarian = LibrarianFactory.createLibrarian("x","y","z","a","b","c",7554,"f",false);
    }

    @Test
    public void createLibrarian() {
        Assert.assertNotNull(librarian);
    }
}