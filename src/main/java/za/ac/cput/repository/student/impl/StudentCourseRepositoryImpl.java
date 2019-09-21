package za.ac.cput.repository.student.impl;

import za.ac.cput.domain.student.StudentCourse;
import za.ac.cput.repository.student.StudentCourseRepository;

import java.util.HashSet;
import java.util.Set;

public class StudentCourseRepositoryImpl implements StudentCourseRepository {
    private static StudentCourseRepository studentCourseRepository = null;
    private Set<StudentCourse> studentCoursesDB;

    private StudentCourseRepositoryImpl(){
        this.studentCoursesDB = new HashSet<>();
    }

    public static StudentCourseRepository getStudentCourseRepository() {
        if (studentCourseRepository == null)studentCourseRepository = new StudentCourseRepositoryImpl();
        return studentCourseRepository;
    }

    private StudentCourse findStudentCourse(String id){
        return this.studentCoursesDB.stream()
                .filter(studentCourse -> studentCourse.getStudentId().trim().equalsIgnoreCase(id))
                .findAny()
                .orElse(null);
    }
    @Override
    public StudentCourse create(StudentCourse studentCourse) {
        this.studentCoursesDB.add(studentCourse);
        return studentCourse;
    }

    @Override
    public StudentCourse read(String s) {
        StudentCourse studentCourse = findStudentCourse(s);
        return studentCourse;
    }

    @Override
    public StudentCourse update(StudentCourse studentCourse) {
        StudentCourse toDelete = findStudentCourse(studentCourse.getStudentId());
        if (toDelete != null){
            this.studentCoursesDB.remove(toDelete);
            return create(studentCourse);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        StudentCourse studentCourse = findStudentCourse(s);
        if (studentCourse != null)this.studentCoursesDB.remove(studentCourse);
    }

    @Override
    public Set<StudentCourse> getAll() {
        return this.studentCoursesDB;
    }
}
