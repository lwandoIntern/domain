package za.ac.cput.repository.demography.impl;

import za.ac.cput.domain.demography.Race;
import za.ac.cput.repository.demography.RaceRepository;

import java.util.HashSet;
import java.util.Set;

public class RaceRepositoryImpl implements RaceRepository {
    private static RaceRepository raceRepository = null;
    private Set<Race> races;

    private RaceRepositoryImpl(){
        this.races = new HashSet<>();
    }

    public static RaceRepository getRaceRepository() {
        if (raceRepository == null)raceRepository = new RaceRepositoryImpl();
        return raceRepository;
    }

    private Race findRace(String s){
        return this.races.stream()
                .filter(race -> race.getRaceId().trim().equalsIgnoreCase(s))
                .findAny()
                .orElse(null);
    }
    @Override
    public Race create(Race race) {
        this.races.add(race);
        return race;
    }

    @Override
    public Race read(String s) {
        Race race = findRace(s);
        return race;
    }

    @Override
    public Race update(Race race) {
        Race toDelete = findRace(race.getRaceId());
        if (toDelete != null){
            this.races.remove(race);
            return create(race);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        Race race = findRace(s);
        if (race != null)
            this.races.remove(race);
    }

    @Override
    public Set<Race> getAll() {
        return this.races;
    }

    @Override
    public Race getByDesc(String desc) {
        return this.races.stream().filter(race -> race.getRaceDescription().equalsIgnoreCase(desc)).findAny().orElse(null);
    }
}
