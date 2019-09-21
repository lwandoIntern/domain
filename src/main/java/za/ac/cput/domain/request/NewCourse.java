package za.ac.cput.domain.request;

public class NewCourse {
    private String courseId,courseName,courseType,subjectName;
    private int duration;
    private int numberOfSubjects;

    public NewCourse(String courseId, String courseName, String courseType, String subjectName, int duration, int numberOfSubjects) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseType = courseType;
        this.subjectName = subjectName;
        this.duration = duration;
        this.numberOfSubjects = numberOfSubjects;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getNumberOfSubjects() {
        return numberOfSubjects;
    }

    public void setNumberOfSubjects(int numberOfSubjects) {
        this.numberOfSubjects = numberOfSubjects;
    }

    @Override
    public String toString() {
        return "NewCourse{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseType='" + courseType + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", duration=" + duration +
                ", numberOfSubjects=" + numberOfSubjects +
                '}';
    }
}
