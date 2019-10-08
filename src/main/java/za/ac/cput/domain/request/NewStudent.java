package za.ac.cput.domain.request;

public class NewStudent {
    private String studentNum;
    private String firstName;
    private String lastName;
    private String addressByTown;
    private String gender;
    private String race;
    private String courseName;
    private String subjectName;
    private int studyLevel;

    public NewStudent(String studentNum, String firstName, String lastName, String addressByTown, String gender, String race, String courseName, String subjectName, int studyLevel) {
        this.studentNum = studentNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressByTown = addressByTown;
        this.gender = gender;
        this.race = race;
        this.courseName = courseName;
        this.subjectName = subjectName;
        this.studyLevel = studyLevel;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddressByTown() {
        return addressByTown;
    }

    public void setAddressByTown(String addressByTown) {
        this.addressByTown = addressByTown;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getStudyLevel() {
        return studyLevel;
    }

    public void setStudyLevel(int studyLevel) {
        this.studyLevel = studyLevel;
    }

    @Override
    public String toString() {
        return "NewStudent{" +
                "studentNum='" + studentNum + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", addressByTown='" + addressByTown + '\'' +
                ", gender='" + gender + '\'' +
                ", race='" + race + '\'' +
                ", courseName='" + courseName + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", studyLevel=" + studyLevel +
                '}';
    }
}
