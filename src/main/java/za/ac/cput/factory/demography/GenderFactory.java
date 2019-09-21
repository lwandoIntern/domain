package za.ac.cput.factory.demography;

import za.ac.cput.domain.demography.Gender;
import za.ac.cput.util.Helper;

public class GenderFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(GenderFactory.class);
    public static Gender createGender(String genderDescription){
        String id = Helper.generateRandomGivenSuffix(SUFFIX);
        return new Gender.Builder()
                .genderId(id)
                .genderDescription(genderDescription)
                .build();
    }
}
