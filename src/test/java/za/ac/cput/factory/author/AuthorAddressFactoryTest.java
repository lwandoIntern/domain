package za.ac.cput.factory.author;

import org.junit.Before;
import org.junit.Test;
import za.ac.cput.domain.author.AuthorAddress;
import za.ac.cput.factory.location.AddressFactory;

import static org.junit.Assert.*;

public class AuthorAddressFactoryTest {

    AuthorAddress authorAddress;
    @Before
    public void setUp() throws Exception {
        authorAddress = AuthorAddressFactory.createAuthorAddress(AuthorFactory.createAuthor("2016maila","Nceba","Goniwe",2).getAuthorEmail(), AddressFactory.createAddress("Milnerton","City",7441).getAddressId());
    }

    @Test
    public void createAuthorAddress() {
        System.out.println(authorAddress.getAuthorEmail()+ "\n"+authorAddress.getAddressId());
        assertNotNull(authorAddress);
    }
}