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

    private RaceServiceImpl(){

    }

    public static RaceService getRaceService() {
        if (raceService == null)raceService = new RaceServiceImpl();
        return raceService;
    }

    @Override
    public Race getByDesc(String s) {
        return this.raceRepository.findAll().stream()
                .filter(race -> race.getRaceDescription().equalsIgnoreCase(s))
                .findAny()
                .get();
    }

    @Override
    public Race create(Race race) {
        return this.raceRepository.save(race);
    }

    @Override
    public Race read(String s) {
        return this.raceRepository.getOne(s);
    }

    @Override
    public Race update(Race race) {
        return this.raceRepository.save(race);
    }

    @Override
    public void delete(String s) {
        this.raceRepository.deleteById(s);
    }

    @Override
    public Set<Race> getAll() {
        Set set = new HashSet();
        set.addAll(this.raceRepository.findAll());
        return set;
    }
}
