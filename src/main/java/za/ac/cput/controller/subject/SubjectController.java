package za.ac.cput.controller.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.ResponseObject;
import za.ac.cput.domain.subject.Subject;
import za.ac.cput.factory.ResponseObjectFactory;
import za.ac.cput.service.subject.impl.SubjectServiceImpl;

@RestController
@RequestMapping("/domain/subject")
public class SubjectController {
    @Autowired
    SubjectServiceImpl subjectService;

    @PostMapping(value = "/create",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createSubject(@RequestBody Subject subject){
        System.out.println(subject);
        ResponseObject responseObject = ResponseObjectFactory.buildGenericResponseObject(HttpStatus.OK.toString(),"Subject created!");
        if (subject.getSubjectName() == null || subject.getDuration() < 0 || subject.getPrerequisite() == null || subject.getPriority() == null){
            responseObject.setResponse(HttpStatus.PRECONDITION_FAILED.toString());
            responseObject.setResponseDescription("Please provide a name and/or duration and/or prerequisite and/or priority");
        }else {
            Subject subject1 = saveSubject(subject);
            responseObject.setResponse(subject1);
        }
        return ResponseEntity.ok(responseObject);
    }
    private Subject saveSubject(Subject subject){
        return subjectService.create(subject);
    }
}
