package za.ac.cput.repository.author;

import za.ac.cput.domain.author.Author;
import za.ac.cput.repository.IRepository;

public interface AuthorRepository extends IRepository<Author,String> {
    Author getByFullName(String fullName);
}
