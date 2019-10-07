package za.ac.cput.service.author;


import za.ac.cput.domain.author.Author;
import za.ac.cput.service.IService;


public interface AuthorService extends IService<Author,String> {
    Author getByFullName(String fullName);
}
