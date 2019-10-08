package za.ac.cput.repository.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.course.CourseSubject;

@Repository
public interface CourseSubjectRepository extends JpaRepository<CourseSubject,String> {
}
