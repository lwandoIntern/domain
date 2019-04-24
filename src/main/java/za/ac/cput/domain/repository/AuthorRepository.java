package za.ac.cput.domain.repository;

import authors.Author;

import java.util.HashSet;
import java.util.Set;

public interface AuthorRepository extends Repository<Author,String>{
    Set<Author> getAll();
}
