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
    public Gender create(Gender gender) {
        this.repository.save(gender);
        return this.repository.getOne(gender.getGenderId());
    }

    @Override
    public Gender read(String s) {
        return repository.getOne(s);
    }

    @Override
    public Gender update(Gender gender) {
        Gender gender1 = read(gender.getGenderId());
        if (gender1 == gender){
            this.repository.delete(gender1);
            this.repository.save(gender);
            return this.repository.getOne(gender.getGenderId());
        }
        return null;
    }

    @Override
    public void delete(String s) {
        repository.deleteById(s);
    }

    @Override
    public Set<Gender> getAll() {
        Set<Gender> genders = new HashSet<>();
        genders.addAll(this.repository.findAll());
        return genders;
    }

    @Override
    public Gender getByDesc(String s) {
        return getAll().stream()
                .filter(gender -> gender.getGenderDescription().equalsIgnoreCase(s))
                .findAny()
                .get();
    }
}
