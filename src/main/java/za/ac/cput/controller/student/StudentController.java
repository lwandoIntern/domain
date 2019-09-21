package za.ac.cput.controller.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.ResponseObject;
import za.ac.cput.domain.course.Course;
import za.ac.cput.domain.demography.Gender;
import za.ac.cput.domain.demography.Race;
import za.ac.cput.domain.location.Address;
import za.ac.cput.domain.request.NewStudent;
import za.ac.cput.domain.staff.Staff;
import za.ac.cput.domain.student.*;
import za.ac.cput.domain.subject.Subject;
import za.ac.cput.factory.ResponseObjectFactory;
import za.ac.cput.factory.student.*;
import za.ac.cput.service.course.CourseService;
import za.ac.cput.service.course.impl.CourseServiceImpl;
import za.ac.cput.service.demography.impl.GenderServiceImpl;
import za.ac.cput.service.demography.impl.RaceServiceImpl;
import za.ac.cput.service.location.impl.AddressServiceImpl;
import za.ac.cput.service.student.impl.*;
import za.ac.cput.service.subject.impl.SubjectServiceImpl;

@RestController
@RequestMapping("/domain/student")
public class StudentController {
    @Autowired
    StudentServiceImpl studentService;
    @Autowired
    SubjectServiceImpl subjectService;
    @Autowired
    CourseServiceImpl courseService;
    @Autowired
    GenderServiceImpl genderService;
    @Autowired
    RaceServiceImpl raceService;
    @Autowired
    AddressServiceImpl addressService;
    @Autowired
    StudentSubjectServiceImpl studentSubjectService;
    @Autowired
    StudentCourseServiceImpl studentCourseService;
    @Autowired
    StudentAddressServiceImpl studentAddressService;
    @Autowired
    StudentDemographyServiceImpl studentDemographyService;

    @PostMapping(value = "/create",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createStudent(@RequestBody NewStudent newStudent){
        System.out.println(newStudent);
        ResponseObject responseObject = ResponseObjectFactory.buildGenericResponseObject(HttpStatus.OK.toString(),"Student created");
        if (newStudent.getFirstName() == null || newStudent.getLastName() == null || newStudent.getStudyLevel() <=0){
            responseObject.setResponse(HttpStatus.PRECONDITION_FAILED.toString());
            responseObject.setResponseDescription("Please provide a name and/or surname and/or level of study");
        }else {
            Address address = getAddress(newStudent);
            Gender gender = getGender(newStudent);
            Race race = getRace(newStudent);
            Course course = getCourse(newStudent);
            Subject subject = getSubject(newStudent);
            if (address == null || gender == null || race == null || course == null || subject == null){
                String message = address == null ? "Address not found!":"";
                message += gender == null ? "Gender not found!":"";
                message += race == null ? "Race not found":"";
                message += course == null ? "Course not found":"";
                message += subject == null ? "Subject not found":"";
                responseObject.setResponse(message);
            }else {
                Student theStudent = saveStudent(newStudent);
                StudentDemography theDemography = saveDemography(theStudent,gender,race);
                StudentAddress studentAddress = saveStudentAddress(theStudent,address);
                StudentCourse studentCourse = saveStudentCourse(theStudent,course);
                StudentSubject studentSubject = saveStudentSubject(theStudent,subject);
                responseObject.setResponse(theStudent);
            }
        }
        return ResponseEntity.ok(responseObject);
    }
    private Student saveStudent(NewStudent newStudent){
        return studentService.create(StudentFactory.createStudent(newStudent.getFirstName(),newStudent.getLastName(),newStudent.getStudyLevel()));
    }
    private StudentSubject saveStudentSubject(Student student,Subject subject){
        return studentSubjectService.create(StudentSubjectFactory.createStudentSubject(student.getStudentId(),subject.getSubjectId()));
    }
    private StudentCourse saveStudentCourse(Student student,Course course){
        return studentCourseService.create(StudentCourseFactory.createStudentCourse(student.getStudentId(),course.getCourseId()));
    }
    private StudentAddress saveStudentAddress(Student student,Address address){
        return studentAddressService.create(StudentAddressFactory.createStudentAddress(student.getStudentId(),address.getAddressId()));
    }
    private StudentDemography saveDemography(Student student,Gender gender,Race race){
        return studentDemographyService.create(StudentDemographyFactory.createStudentDemography(student.getStudentId(),race.getRaceId(),gender.getGenderId()));
    }
    private Gender getGender(NewStudent newStudent){
        return genderService.getByDesc(newStudent.getAddressByTown());
    }
    private Race getRace(NewStudent newStudent){
        return raceService.getByDesc(newStudent.getAddressByTown());
    }
    private Course getCourse(NewStudent newStudent){
        return courseService.getCourseByName(newStudent.getCourseName());
    }
    private Subject getSubject(NewStudent newStudent){
        return subjectService.getByName(newStudent.getSubjectName());
    }
    private Address getAddress(NewStudent newStudent){
        return addressService.getByTown(newStudent.getAddressByTown());
    }
}
