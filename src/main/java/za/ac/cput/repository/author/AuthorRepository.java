package za.ac.cput.repository.author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.author.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author,String> {

}
