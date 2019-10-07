package za.ac.cput.controller.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

import java.util.Set;

@RestController
@RequestMapping("/domain/student")
public class StudentController {
    @Autowired
    StudentServiceImpl studentService;

    @PostMapping(value = "/create")
    @ResponseBody
    public Student create(@RequestBody Student student){
        return this.studentService.create(student);
    }
    @GetMapping(value = "/read/{id}")
    @ResponseBody
    public Student read(@PathVariable String s){
        return this.studentService.read(s);
    }
    @PutMapping(value = "/update")
    @ResponseBody
    public Student update(@RequestBody Student student){
        return this.studentService.update(student);
    }
    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable String id){
        this.studentService.delete(id);
    }
    @GetMapping(value = "/getall")
    @ResponseBody
    public Set<Student> getAll(){
        return this.studentService.getAll();
    }

}
