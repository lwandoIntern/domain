package za.ac.cput.service.demography.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.demography.Race;
import za.ac.cput.repository.demography.RaceRepository;
import za.ac.cput.service.demography.RaceService;


import java.util.HashSet;
import java.util.Set;

@Service
public class RaceServiceImpl implements RaceService {
    private static RaceService raceService = null;
    @Autowired
    private RaceRepository raceRepository;

    private RaceServiceImpl(){}

    public static RaceService getRaceService() {
        if (raceService == null)raceService = new RaceServiceImpl();
        return raceService;
    }

    @Override
    public Race create(Race race) {
        this.raceRepository.save(race);
        return this.raceRepository.getOne(race.getRaceId());
    }

    @Override
    public Race read(String s) {
        return raceRepository.getOne(s);
    }

    @Override
    public Race update(Race race) {
        Race race1 = read(race.getRaceId());
        if (race1 == race){
            this.raceRepository.delete(race1);
            this.raceRepository.save(race);
            return this.raceRepository.getOne(race.getRaceId());
        }
        return null;
    }

    @Override
    public void delete(String s) {
        raceRepository.deleteById(s);
    }

    @Override
    public Set<Race> getAll() {
        Set<Race> races = new HashSet<>();
        races.addAll(this.raceRepository.findAll());
        return races;
    }

    @Override
    public Race getByDesc(String s) {
        return getAll().stream()
                .filter(race -> race.getRaceDescription().equalsIgnoreCase(s))
                .findAny()
                .get();
    }
}
