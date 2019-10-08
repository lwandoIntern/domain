package za.ac.cput.repository.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.course.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,String> {

}
