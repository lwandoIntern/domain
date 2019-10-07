package za.ac.cput.domain.course;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Course implements Serializable {
    @Id
    @Column(name="course_id")
    private String courseId;
    @Column(name="course_name")
    private String courseName;
    @Column(name="type")
    private String courseType;
    @Column(name="course_duration")
    private int duration;
    @Column(name="number_of_subjects")
    private int numOfSubjects;

    private Course(){}
    public Course(Builder builder) {
        this.courseId = builder.courseId;
        this.courseName = builder.courseName;
        this.courseType = builder.courseType;
        this.duration = builder.duration;
        this.numOfSubjects = builder.numOfSubjects;
    }

    public int getNumOfSubjects() {
        return numOfSubjects;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseType() {
        return courseType;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseType='" + courseType + '\'' +
                ", duration=" + duration +
                ", numOfSubjects=" + numOfSubjects +
                '}';
    }
    public static class Builder{
        private String courseId,courseName,courseType;
        private int duration,numOfSubjects;

        public Builder courseId(String id){
            this.courseId = id;
            return this;
        }
        public Builder courseName(String courseName){
            this.courseName = courseName;
            return this;
        }
        public Builder courseType(String type){
            this.courseType = type;
            return this;
        }
        public Builder duration(int courseDuration){
            this.duration = courseDuration;
            return this;
        }
        public Builder numOfSubjects(int numberOfSubjectsInCourse){
            this.numOfSubjects = numberOfSubjectsInCourse;
            return this;
        }
        public Course build(){
            return new Course(this);
        }
    }
}
