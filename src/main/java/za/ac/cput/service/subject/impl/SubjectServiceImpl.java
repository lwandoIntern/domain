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
    public Subject getByName(String subjectName) {
        return this.subjectRepository.findAll().stream()
                .filter(subject -> subject.getSubjectName().equalsIgnoreCase(subjectName))
                .findAny()
                .get();
    }

    @Override
    public Subject create(Subject subject) {
        return this.subjectRepository.save(subject);
    }

    @Override
    public Subject read(String s) {
        return this.subjectRepository.getOne(s);
    }

    @Override
    public Subject update(Subject subject) {
        return this.subjectRepository.save(subject);
    }

    @Override
    public void delete(String s) {this.subjectRepository.deleteById(s);}

    @Override
    public Set<Subject> getAll() {
        Set set = new HashSet();
        set.addAll(this.subjectRepository.findAll());
        return set;
    }
}
