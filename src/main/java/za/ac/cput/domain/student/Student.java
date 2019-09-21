package za.ac.cput.domain.student;

import java.util.Objects;

public class Student {
    private String studentId,firstName,lastName;
    private int studyLevel;

    public Student(Builder builder) {
        this.studentId = builder.studentId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.studyLevel = builder.studyLevel;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getStudyLevel() {
        return studyLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentId.equals(student.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }
    public static class Builder{
        private String studentId,firstName,lastName;
        private int studyLevel;
        public Builder studentId(String id){
            this.studentId = id;
            return this;
        }
        public Builder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }
        public Builder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }
        public Builder studyLevel(int studyLevel){
            this.studyLevel = studyLevel;
            return this;
        }
        public Student build(){
            return new Student(this);
        }
    }
}
