package za.ac.cput.domain.request;

public class NewStaff {
    private String staffNum;
    private String firstName;
    private String lastName;
    private String addressByTown;
    private String gender;
    private String race;
    private String role;

    public NewStaff(String staffNum, String firstName, String lastName, String addressByTown, String gender, String race, String role) {
        this.staffNum = staffNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressByTown = addressByTown;
        this.gender = gender;
        this.race = race;
        this.role = role;
    }

    public String getStaffNum() {
        return staffNum;
    }

    public void setStaffNum(String staffNum) {
        this.staffNum = staffNum;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "NewStaff{" +
                "staffNum='" + staffNum + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", addressByTown='" + addressByTown + '\'' +
                ", gender='" + gender + '\'' +
                ", race='" + race + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
