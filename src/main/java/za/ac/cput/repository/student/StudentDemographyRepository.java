package za.ac.cput.repository.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.student.StudentDemography;

@Repository
public interface StudentDemographyRepository extends JpaRepository<StudentDemography,String> {
}
