package za.ac.cput.repository.publisher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.publisher.PublisherAddress;

@Repository
public interface PublisherAddressRepository extends JpaRepository<PublisherAddress,String> {
}
