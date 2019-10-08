package za.ac.cput.repository.books;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.books.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,String> {

}
