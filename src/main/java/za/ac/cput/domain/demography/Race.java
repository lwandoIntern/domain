package za.ac.cput.domain.demography;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Race implements Serializable {
    @Id
    @Column(name = "race_id")
    private String raceId;
    @Column(name = "description")
    private String raceDescription;

    private Race(){}
    public Race(Builder builder) {
        this.raceId = builder.raceId;
        this.raceDescription = builder.raceDescription;
    }

    public String getRaceId() {
        return raceId;
    }

    public String getRaceDescription() {
        return raceDescription;
    }

    @Override
    public String toString() {
        return "Race{" +
                "raceId='" + raceId + '\'' +
                ", raceDescription='" + raceDescription + '\'' +
                '}';
    }
    public static class Builder{
        private String raceId,raceDescription;
        public Builder raceId(String id){
            this.raceId = id;
            return this;
        }
        public Builder raceDescription(String raceDescription){
            this.raceDescription = raceDescription;
            return this;
        }
        public Race build(){
            return new Race(this);
        }
    }
}
