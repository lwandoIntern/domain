package za.ac.cput.factory.demography;

import za.ac.cput.domain.demography.Race;
import za.ac.cput.util.Helper;

public class RaceFactory {

    public static Race createRace(String raceDesc){

        return new Race.Builder()

                .raceDescription(raceDesc)
                .build();
    }
}
