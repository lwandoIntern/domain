package za.ac.cput.domain.Factory.author;

import za.ac.cput.domain.domain.authors.Author;
import za.ac.cput.domain.domain.value_objects.Address;
import za.ac.cput.domain.domain.value_objects.Contacts;
import za.ac.cput.domain.domain.value_objects.Names;

public class AuthorFactory {
    public static Author createAuthor(String id, Names names, Contacts contacts, Address address,int num){
        return new Author.Builder()
                .authId(id)
                .name(names)
                .contacts(contacts)
                .address(address)
                .numOfBooksWritten(num)
                .build();
    }
}
