package za.ac.cput.domain.domain.employee;

import za.ac.cput.domain.domain.value_objects.Address;
import za.ac.cput.domain.domain.value_objects.Contacts;
import za.ac.cput.domain.domain.value_objects.Names;
import za.ac.cput.domain.domain.value_objects.Position;

import java.util.Objects;


public class Librarian implements Employee{
    private boolean hasAssistant;
    private String employeeId;
    private Names name;
    private Address address;
    private Contacts contacts;
    private Position position;

    private Librarian(){}
    public Librarian(Builder builder){
        this.employeeId = builder.employeeId;
        this.hasAssistant = builder.hasAssistant;
        this.name = builder.name;
        this.address = builder.address;
        this.contacts = builder.contacts;
        this.position = builder.position;
    }

    public Names getName() {
        return name;
    }

    @Override
    public String getEmployeeId() {
        return employeeId;
    }

    public static class Builder{
        private boolean hasAssistant;
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
        public Builder position(Position value){
            this.position = value;
            return this;
        }
        public Builder address(Address value){
            this.address = value;
            return this;
        }
        public Builder contacts(Contacts v){
            this.contacts = v;
            return this;
        }
        public Builder hasAssistant(boolean hasAssistant){
            this.hasAssistant = hasAssistant;
            return this;
        }
        public Librarian build(){
            return new Librarian(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Librarian librarian = (Librarian) o;
        return employeeId.equals(librarian.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }
}
