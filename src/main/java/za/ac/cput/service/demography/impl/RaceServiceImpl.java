package za.ac.cput.service.demography.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.demography.Race;
import za.ac.cput.repository.demography.RaceRepository;
import za.ac.cput.repository.demography.impl.RaceRepositoryImpl;
import za.ac.cput.service.demography.RaceService;

import java.util.Set;

@Service
public class RaceServiceImpl implements RaceService {
    private static RaceService raceService = null;
    private RaceRepository raceRepository;

    private RaceServiceImpl(){
        this.raceRepository = RaceRepositoryImpl.getRaceRepository();
    }

    public static RaceService getRaceService() {
        if (raceService == null)raceService = new RaceServiceImpl();
        return raceService;
    }

    @Override
    public Race create(Race race) {
        return raceRepository.create(race);
    }

    @Override
    public Race read(String s) {
        return raceRepository.read(s);
    }

    @Override
    public Race update(Race race) {
        return raceRepository.update(race);
    }

    @Override
    public void delete(String s) {
        raceRepository.delete(s);
    }

    @Override
    public Set<Race> getAll() {
        return raceRepository.getAll();
    }

    @Override
    public Race getByDesc(String s) {
        return this.raceRepository.getByDesc(s);
    }
}
