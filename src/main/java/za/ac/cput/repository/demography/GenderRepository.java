package za.ac.cput.repository.demography;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.demography.Gender;

@Repository
public interface GenderRepository extends JpaRepository<Gender,String> {

}
