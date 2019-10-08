package za.ac.cput.domain.publisher;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "publisher_id",nullable = false,columnDefinition = "VARCHAR(20)")
    private String publisherId;
    private String name;

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
        return publisherId == publisher.publisherId;
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
        private String publisherId;
        private String name;
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
