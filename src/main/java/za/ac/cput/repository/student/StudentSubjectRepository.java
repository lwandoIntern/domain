package za.ac.cput.repository.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.student.StudentSubject;

@Repository
public interface StudentSubjectRepository extends JpaRepository<StudentSubject,String> {
}
