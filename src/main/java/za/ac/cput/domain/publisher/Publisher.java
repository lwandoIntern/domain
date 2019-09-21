package za.ac.cput.domain.publisher;

import java.util.Objects;

public class Publisher {
    private String publisherId,name;

    public Publisher(Builder builder) {
        this.publisherId = builder.publisherId;
        this.name = builder.name;
    }

    public String getPublisherId() {
        return publisherId;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return publisherId.equals(publisher.publisherId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publisherId);
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "publisherId='" + publisherId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
    public static class Builder{
        private String publisherId,name;
        public Builder publisherId(String pubId){
            this.publisherId = pubId;
            return this;
        }
        public Builder name(String name){
            this.name = name;
            return this;
        }
        public Publisher build(){
            return new Publisher(this);
        }
    }
}
