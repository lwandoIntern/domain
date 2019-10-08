package za.ac.cput.repository.subject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.subject.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,String> {

}
