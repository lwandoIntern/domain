package za.ac.cput.domain.repository.authorRepository;

import authors.Author;
import za.ac.cput.domain.repository.Repository;

import java.util.HashSet;
import java.util.Set;

public interface AuthorRepository extends Repository<Author,String> {
    Set<Author> getAll();
}
