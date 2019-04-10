package model;

public class Author {
    private int authId;
    private String name,lastName,address,phone;

    private Author(){}
    public Author(Builder builder){
        this.authId = builder.authId;
        this.name = builder.name;
        this.lastName = builder.lastName;
        this.address = builder.address;
        this.phone = builder.phone;
    }

    public int getAuthId() {
        return authId;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public static class Builder{
        private int authId;
        private String name,lastName,address,phone;

        public Builder authId(int value){
            this.authId = value;
            return this;
        }

        public Builder name(String value){
            this.name = value;
            return this;
        }
        public Builder lastName(String value){
            this.lastName = value;
            return this;
        }
        public Builder address(String value){
            this.address = value;
            return this;
        }
        public Builder phone(String value){
            this.phone = value;
            return this;
        }
        public Builder copy(Author author){
            this.authId = author.authId;
            this.name = author.name;
            this.lastName = author.lastName;
            this.address = author.address;
            this.phone = author.phone;
            return this;
        }
        public Author build(){
            return new Author(this);
        }
    }
}
