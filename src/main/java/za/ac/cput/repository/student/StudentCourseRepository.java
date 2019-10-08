package za.ac.cput.repository.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.student.StudentCourse;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse,String> {
}
