package za.ac.cput.domain.repository.authorRepository;

import za.ac.cput.domain.domain.authors.Author;
import za.ac.cput.domain.repository.Repository;

import java.util.Set;

public interface AuthorRepository extends Repository<Author,String> {
    Set<Author> getAll();
}
