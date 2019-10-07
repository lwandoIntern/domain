package za.ac.cput.domain.demography;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Gender implements Serializable {
    @Id
    @Column(name = "gender_id")
    private String genderId;
    @Id
    @Column(name = "gender_description")
    private String genderDescription;

    private Gender(){}
    public Gender(Builder builder) {
        this.genderId = builder.genderId;
        this.genderDescription = builder.genderDescription;
    }

    public String getGenderId() {
        return genderId;
    }

    public String getGenderDescription() {
        return genderDescription;
    }

    @Override
    public String toString() {
        return "Gender{" +
                "genderId='" + genderId + '\'' +
                ", genderDescription='" + genderDescription + '\'' +
                '}';
    }
    public static class Builder{
        private String genderId,genderDescription;
        public Builder genderId(String id){
            this.genderId = id;
            return this;
        }
        public Builder genderDescription(String genderDesc){
            this.genderDescription = genderDesc;
            return this;
        }
        public Gender build(){
            return new Gender(this);
        }
    }
}
