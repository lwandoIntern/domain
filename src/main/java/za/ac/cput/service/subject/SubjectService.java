package za.ac.cput.service.subject;

import za.ac.cput.domain.subject.Subject;
import za.ac.cput.service.IService;

public interface SubjectService extends IService<Subject,String> {
    Subject getByName(String subjectName);
}
