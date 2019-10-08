package za.ac.cput.service.demography.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.demography.Gender;
import za.ac.cput.repository.demography.GenderRepository;

import za.ac.cput.service.demography.GenderService;

import java.util.HashSet;
import java.util.Set;

@Service
public class GenderServiceImpl implements GenderService {
    private static GenderService genderService = null;
    @Autowired
    private GenderRepository repository;

    private GenderServiceImpl(){}

    public static GenderService getGenderService() {
        if (genderService == null)genderService = new GenderServiceImpl();
        return genderService;
    }

    @Override
    public Gender getByDesc(String s) {
        return this.repository.findAll().stream()
                .filter(gender -> gender.getGenderDescription().equalsIgnoreCase(s))
                .findAny().get();
    }

    @Override
    public Gender create(Gender gender) {
        return this.repository.save(gender);
    }

    @Override
    public Gender read(String s) {
        return this.repository.getOne(s);
    }

    @Override
    public Gender update(Gender gender) {
        return this.repository.save(gender);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }

    @Override
    public Set<Gender> getAll() {
        Set set = new HashSet();
        set.addAll(this.repository.findAll());
        return set;
    }
}
