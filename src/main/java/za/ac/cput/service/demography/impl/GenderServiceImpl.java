package za.ac.cput.service.demography.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.demography.Gender;
import za.ac.cput.repository.demography.GenderRepository;
import za.ac.cput.repository.demography.impl.GenderRepositoryImpl;
import za.ac.cput.service.demography.GenderService;

import java.util.Set;

@Service
public class GenderServiceImpl implements GenderService {
    private static GenderService genderService = null;
    private GenderRepository repository;

    private GenderServiceImpl(){
        this.repository = GenderRepositoryImpl.getGenderRepository();
    }

    public static GenderService getGenderService() {
        if (genderService == null)genderService = new GenderServiceImpl();
        return genderService;
    }

    @Override
    public Gender create(Gender gender) {
        return repository.create(gender);
    }

    @Override
    public Gender read(String s) {
        return repository.read(s);
    }

    @Override
    public Gender update(Gender gender) {
        return repository.update(gender);
    }

    @Override
    public void delete(String s) {
        repository.delete(s);
    }

    @Override
    public Set<Gender> getAll() {
        return repository.getAll();
    }

    @Override
    public Gender getByDesc(String s) {
        return this.repository.getByDesc(s);
    }
}
