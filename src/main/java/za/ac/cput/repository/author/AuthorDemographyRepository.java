package za.ac.cput.repository.author;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.author.AuthorDemography;
@Repository
public interface AuthorDemographyRepository extends JpaRepository<AuthorDemography,String> {
}
