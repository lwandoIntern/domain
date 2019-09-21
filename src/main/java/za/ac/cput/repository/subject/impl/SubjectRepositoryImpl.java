package za.ac.cput.repository.subject.impl;

import za.ac.cput.domain.subject.Subject;
import za.ac.cput.repository.subject.SubjectRepository;

import java.util.HashSet;
import java.util.Set;

public class SubjectRepositoryImpl implements SubjectRepository {
    private static SubjectRepository subjectRepository = null;
    private Set<Subject> subjectsDB;

    private SubjectRepositoryImpl(){
        this.subjectsDB = new HashSet<>();
    }

    public static SubjectRepository getSubjectRepository() {
        if (subjectRepository == null)subjectRepository = new SubjectRepositoryImpl();
        return subjectRepository;
    }

    private Subject findSubject(String id){
        return this.subjectsDB.stream()
                .filter(subject -> subject.getSubjectId().trim().equalsIgnoreCase(id))
                .findAny()
                .orElse(null);
    }
    @Override
    public Subject create(Subject subject) {
        this.subjectsDB.add(subject);
        return subject;
    }

    @Override
    public Subject read(String s) {
        Subject subject = findSubject(s);
        return subject;
    }

    @Override
    public Subject update(Subject subject) {
        Subject toDelete = findSubject(subject.getSubjectId());
        if (toDelete != null){
            this.subjectsDB.remove(toDelete);
            return create(subject);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        Subject subject = findSubject(s);
        if(subject !=null)this.subjectsDB.remove(subject);
    }

    @Override
    public Set<Subject> getAll() {
        return this.subjectsDB;
    }
}
