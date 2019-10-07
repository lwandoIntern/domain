package za.ac.cput.service.subject.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.subject.Subject;
import za.ac.cput.repository.subject.SubjectRepository;
import za.ac.cput.service.subject.SubjectService;


import java.util.HashSet;
import java.util.Set;

@Service
public class SubjectServiceImpl implements SubjectService {
    private static SubjectService subjectService = null;
    @Autowired
    private SubjectRepository subjectRepository;

    private SubjectServiceImpl(){}

    public static SubjectService getSubjectService() {
        if (subjectService == null)subjectService = new SubjectServiceImpl();
        return subjectService;
    }

    @Override
    public Subject create(Subject subject) {
        this.subjectRepository.save(subject);
        return read(subject.getSubjectId());
    }

    @Override
    public Subject read(String s) {
        return this.subjectRepository.getOne(s);
    }

    @Override
    public Subject update(Subject subject) {
        Subject subject1 = read(subject.getSubjectId());
        if (subject1 == subject){
            delete(subject1.getSubjectId());
            return create(subject);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        if (read(s) != null)
            this.subjectRepository.deleteById(s);
    }

    @Override
    public Set<Subject> getAll() {
        Set<Subject> subjects = new HashSet<>();
        subjects.addAll(this.subjectRepository.findAll());
        return subjects;
    }

    @Override
    public Subject getByName(String subjectName) {
        return getAll().stream()
                .filter(subject -> subject.getSubjectName().equalsIgnoreCase(subjectName))
                .findAny()
                .get();
    }
}
