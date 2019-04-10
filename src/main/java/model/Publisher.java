package model;

public class Publisher {
    private String id;
    private String name,address,phone;

    private Publisher(){}
    public Publisher(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.address = builder.address;
        this.phone = builder.phone;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public static class Builder{
        private String id;
        private String name,address,phone;

        public Builder id(String value){
            this.id = value;
            return this;
        }
        public Builder name(String value){
            this.name = value;
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
        public Builder copy(Publisher publisher){
            this.id = publisher.id;
            this.name = publisher.name;
            this.address =publisher.address;
            this.phone = publisher.phone;
            return this;
        }
        public Publisher build(){
            return new Publisher(this);
        }
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
