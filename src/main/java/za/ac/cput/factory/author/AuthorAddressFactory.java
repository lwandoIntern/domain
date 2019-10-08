package za.ac.cput.factory.author;

import za.ac.cput.domain.author.AuthorAddress;
import za.ac.cput.util.Helper;

public class AuthorAddressFactory {
    public static AuthorAddress createAuthorAddress(String authorEmail, String addressId){
        return new AuthorAddress(authorEmail,addressId);
    }
}
