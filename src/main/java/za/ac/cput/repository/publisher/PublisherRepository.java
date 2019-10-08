package za.ac.cput.repository.publisher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.publisher.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher,String> {

}
