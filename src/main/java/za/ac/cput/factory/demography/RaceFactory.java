package za.ac.cput.factory.demography;

import za.ac.cput.domain.demography.Race;
import za.ac.cput.util.Helper;

public class RaceFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(RaceFactory.class);
    public static Race createRace(String raceDesc){
        String id = Helper.generateRandomGivenSuffix(SUFFIX);
        return new Race.Builder()
                .raceId(id)
                .raceDescription(raceDesc)
                .build();
    }
}
