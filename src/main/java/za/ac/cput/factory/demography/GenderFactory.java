package za.ac.cput.factory.demography;

import za.ac.cput.domain.demography.Gender;
import za.ac.cput.util.Helper;

public class GenderFactory {

    public static Gender createGender(String genderDescription){

        return new Gender.Builder()

                .genderDescription(genderDescription)
                .build();
    }
}
