package za.ac.cput.domain.demography;

import javax.persistence.*;

@Entity
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "gender_id",nullable = false,columnDefinition = "VARCHAR(20)")
    private String genderId;
    private String genderDescription;

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
        private String genderId;
        private String genderDescription;
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
