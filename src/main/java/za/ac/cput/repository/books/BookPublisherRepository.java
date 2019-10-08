package za.ac.cput.repository.books;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.books.BookPublisher;

@Repository
public interface BookPublisherRepository extends JpaRepository<BookPublisher,String> {
}
