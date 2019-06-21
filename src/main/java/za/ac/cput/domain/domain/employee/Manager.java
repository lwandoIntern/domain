package za.ac.cput.domain.domain.employee;

import za.ac.cput.domain.domain.value_objects.Address;
import za.ac.cput.domain.domain.value_objects.Contacts;
import za.ac.cput.domain.domain.value_objects.Names;
import za.ac.cput.domain.domain.value_objects.Position;

import java.util.Objects;


public class Manager implements Employee{
    private String employeeId;
    private Names name;
    private Address address;
    private Contacts contacts;
    private Position position;

    private Manager(){}
    public Manager(Builder builder){
        this.employeeId = builder.employeeId;
        this.name = builder.name;
        this.address = builder.address;
        this.contacts = builder.contacts;
        this.position = builder.position;
    }

    public Names getName() {
        return name;
    }
    public Position getPosition() {
        return position;
    }
    public Address getAddress() {
        return address;
    }
    public Contacts getContacts() {
        return contacts;
    }

    @Override
    public String getEmployeeId() {
        return employeeId;
    }

    public static class Builder{
        private String employeeId;
        private Names name;
        private Address address;
        private Contacts contacts;
        private Position position;

        public Builder employeeId(String value){
            this.employeeId = value;
            return this;
        }
        public Builder name(Names value){
            this.name = value;
            return this;
        }
        public Builder address(Address value){
            this.address = value;
            return this;
        }
        public Builder contacts(Contacts value){
            this.contacts = value;
            return this;
        }
        public Builder position(Position v){
            this.position = v;
            return this;
        }
        public Manager build(){
            return new Manager(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return employeeId.equals(manager.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }
}
