package za.ac.cput.domain.subject;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "subject_id",nullable = false,columnDefinition = "VARCHAR(8)")
    private String subjectId;
    private String subjectName;
    private String priority;
    private String prerequisite;
    private int duration;

    public Subject(Builder builder) {
        this.subjectId = builder.subjectId;
        this.subjectName = builder.subjectName;
        this.priority = builder.priority;
        this.prerequisite = builder.prerequisite;
        this.duration = builder.duration;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getPriority() {
        return priority;
    }

    public String getPrerequisite() {
        return prerequisite;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return subjectId == subject.subjectId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectId);
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId='" + subjectId + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", priority='" + priority + '\'' +
                ", prerequisite='" + prerequisite + '\'' +
                ", duration=" + duration +
                '}';
    }
    public static class Builder{
        private String subjectId;
        private String subjectName;
        private String priority;
        private String prerequisite;
        private int duration;
        public Builder subjectId(String id){
            this.subjectId = id;
            return this;
        }
        public Builder subjectName(String subjectName){
            this.subjectName = subjectName;
            return this;
        }
        public Builder priority(String priority){
            this.priority = priority;
            return this;
        }
        public Builder prerequisite(String prerequisite){
            this.prerequisite = prerequisite;
            return this;
        }
        public Builder duration(int duration){
            this.duration = duration;
            return this;
        }
        public Subject build(){
            return new Subject(this);
        }
    }
}
