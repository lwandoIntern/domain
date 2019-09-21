package za.ac.cput.service.subject.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.subject.Subject;
import za.ac.cput.repository.subject.SubjectRepository;
import za.ac.cput.repository.subject.impl.SubjectRepositoryImpl;
import za.ac.cput.service.subject.SubjectService;

import java.util.Set;

@Service
public class SubjectServiceImpl implements SubjectService {
    private static SubjectService subjectService = null;
    private SubjectRepository subjectRepository;

    private SubjectServiceImpl(){
        this.subjectRepository = SubjectRepositoryImpl.getSubjectRepository();
    }

    public static SubjectService getSubjectService() {
        if (subjectService == null)subjectService = new SubjectServiceImpl();
        return subjectService;
    }

    @Override
    public Subject create(Subject subject) {
        return this.subjectRepository.create(subject);
    }

    @Override
    public Subject read(String s) {
        return this.subjectRepository.read(s);
    }

    @Override
    public Subject update(Subject subject) {
        return this.subjectRepository.update(subject);
    }

    @Override
    public void delete(String s) {
        this.subjectRepository.delete(s);
    }

    @Override
    public Set<Subject> getAll() {
        return this.subjectRepository.getAll();
    }

    @Override
    public Subject getByName(String subjectName) {
        return this.subjectRepository.getByName(subjectName);
    }
}
