package za.ac.cput.controller.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.ResponseObject;
import za.ac.cput.domain.course.Course;
import za.ac.cput.domain.course.CourseSubject;
import za.ac.cput.domain.request.NewCourse;
import za.ac.cput.domain.subject.Subject;
import za.ac.cput.factory.ResponseObjectFactory;
import za.ac.cput.factory.course.CourseFactory;
import za.ac.cput.factory.course.CourseSubjectFactory;
import za.ac.cput.service.course.impl.CourseServiceImpl;
import za.ac.cput.service.course.impl.CourseSubjectServiceImpl;
import za.ac.cput.service.subject.impl.SubjectServiceImpl;

@RestController
@RequestMapping("/domain/course")
public class CourseController {
    @Autowired
    CourseServiceImpl courseService;
    @Autowired
    CourseSubjectServiceImpl courseSubjectService;
    @Autowired
    SubjectServiceImpl subjectService;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createCourse(NewCourse newCourse){
        System.out.println(newCourse);
        ResponseObject responseObject = ResponseObjectFactory.buildGenericResponseObject(HttpStatus.OK.toString(),"Course created!");
        if (newCourse.getCourseName() == null || newCourse.getCourseType() == null || newCourse.getDuration() > 0 || newCourse.getNumberOfSubjects() > 0){
            responseObject.setResponse(HttpStatus.PRECONDITION_FAILED.toString());
            responseObject.setResponseDescription("Please provide course name and/or course type and/or duration and/or number of subjects");
        }else {
            Subject subject = getSubject(newCourse);
            if (subject == null){
                String message = subject == null ? "Subject not found": "";
                responseObject.setResponseDescription(message);
            }else {
                Course saveCour = saveCourse(newCourse);
                CourseSubject saveCourseSub = saveCourseSubject(saveCour,subject);
                responseObject.setResponse(saveCour);
            }
        }
        return ResponseEntity.ok(responseObject);
    }
    private CourseSubject saveCourseSubject(Course course,Subject subject){
        return courseSubjectService.create(
                CourseSubjectFactory.createCourseSubject(course.getCourseId(),subject.getSubjectId()));
    }
    private Subject getSubject(NewCourse course){
        return subjectService.getByName(course.getSubjectName());
    }
    private Course saveCourse(NewCourse course){
        return courseService.create(
                CourseFactory.createCourse(course.getCourseName(),course.getCourseType(),course.getDuration(),
                        course.getNumberOfSubjects()));
    }
}
