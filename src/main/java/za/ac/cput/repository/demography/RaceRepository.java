package za.ac.cput.repository.demography;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.demography.Race;

@Repository
public interface RaceRepository extends JpaRepository<Race,String> {

}
