package za.ac.cput.controller.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.ResponseObject;
import za.ac.cput.domain.subject.Subject;
import za.ac.cput.factory.ResponseObjectFactory;
import za.ac.cput.service.subject.impl.SubjectServiceImpl;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/domain/subject")
public class SubjectController {
    @Autowired
    SubjectServiceImpl subjectService;

    @PostMapping(value = "/create",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Subject create(@RequestBody Subject subject){
        System.out.println(subject);
        ResponseObject responseObject = ResponseObjectFactory.buildGenericResponseObject(HttpStatus.OK.toString(),"Subject created!");
        if (subject.getSubjectName() == null || subject.getDuration() < 0 || subject.getPrerequisite() == null || subject.getPriority() == null){
            responseObject.setResponse(HttpStatus.PRECONDITION_FAILED.toString());
            responseObject.setResponseDescription("Please provide a name and/or duration and/or prerequisite and/or priority");
        }else {

            responseObject.setResponse(subject);

        }
        System.out.println(responseObject);
        return subject;
    }

    @GetMapping(value = "/read",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Subject read(@PathVariable String subjId){
        ResponseObject responseObject = ResponseObjectFactory.buildGenericResponseObject(HttpStatus.OK.toString(),"Reading Subject");
        Subject subject = subjectService.read(subjId);
        if (subject == null){
            responseObject.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObject.setResponseDescription("Subject does not exist");
        }
        responseObject.setResponse(subject);
        System.out.println(responseObject);
        return subject;
    }

    @PutMapping(value = "/update",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Subject update(@RequestBody Subject subject){
        ResponseObject responseObject = ResponseObjectFactory.buildGenericResponseObject(HttpStatus.OK.toString(),"Updating subject");
        Subject subject1 = subjectService.update(subject);
        return subject1;
    }

    @DeleteMapping("/delete")
    public void delete(@PathVariable String subhId){
        subjectService.delete(subhId);
    }

    @GetMapping("/getAll")
    public Set<Subject> getAll(){
        return subjectService.getAll();
    }

}
