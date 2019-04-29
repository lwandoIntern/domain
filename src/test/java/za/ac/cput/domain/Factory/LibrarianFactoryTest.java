package za.ac.cput.domain.Factory;

import za.ac.cput.domain.Factory.staff.LibrarianFactory;
import za.ac.cput.domain.domain.employees.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LibrarianFactoryTest {

    private Employee librarian;
    @Before
    public void setUp() throws Exception {
        librarian = LibrarianFactory.createLibrarian("j4","x","y","z","a","b","c",7554,"f",false);
    }

    @Test
    public void createLibrarian() {
        Assert.assertNotNull(librarian);
    }
}