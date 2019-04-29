package za.ac.cput.domain.services.author;

import za.ac.cput.domain.domain.authors.Author;
import za.ac.cput.domain.services.Service;

import java.util.Set;

public interface AuthorService extends Service<Author,String> {
    Set<Author> getAllAuthors();
}
