package za.ac.cput.domain.student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Student implements Serializable {
    @Id
    @Column(name = "student_email")
    private String studentEmail;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "year_of_study")
    private int studyLevel;
    @Column(name = "password")
    private String password;

    private Student(){}
    public Student(Builder builder) {
        this.studentEmail = builder.studentEmail;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.studyLevel = builder.studyLevel;
    }

    public String getStudentEmail() {
        return studentEmail;
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

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentEmail.equals(student.studentEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentEmail);
    }
    public static class Builder{
        private String studentEmail,firstName,lastName,password;
        private int studyLevel;
        public Builder studentEmail(String email){
            this.studentEmail = email;
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
        public Builder password(String psw){
            this.password = psw;
            return this;
        }
        public Student build(){
            return new Student(this);
        }
    }
}
