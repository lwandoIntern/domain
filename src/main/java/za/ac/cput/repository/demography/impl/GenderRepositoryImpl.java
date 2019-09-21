package za.ac.cput.repository.demography.impl;

import za.ac.cput.domain.demography.Gender;
import za.ac.cput.repository.demography.GenderRepository;

import java.util.HashSet;
import java.util.Set;

public class GenderRepositoryImpl implements GenderRepository {
    private static GenderRepository genderRepository = null;
    private Set<Gender> genders;

    private GenderRepositoryImpl(){
        this.genders = new HashSet<>();
    }

    public static GenderRepository getGenderRepository() {
        if (genderRepository == null)genderRepository = new GenderRepositoryImpl();
        return genderRepository;
    }
    private Gender findGender(String s){
        return this.genders.stream()
                .filter(gender -> gender.getGenderId().trim().equalsIgnoreCase(s))
                .findAny()
                .orElse(null);
    }

    @Override
    public Gender create(Gender gender) {
        this.genders.add(gender);
        return gender;
    }

    @Override
    public Gender read(String s) {
        Gender gender = findGender(s);
        return gender;
    }

    @Override
    public Gender update(Gender gender) {
        Gender toDelete = findGender(gender.getGenderId());
        if (toDelete != null){
            this.genders.remove(toDelete);
            return create(gender);
        }
        return null;
    }

    @Override
    public Gender getByDesc(String desc){
        return this.genders.stream()
                .filter(gender -> gender.getGenderDescription().equalsIgnoreCase(desc))
                .findAny()
                .orElse(null);
    }
    @Override
    public void delete(String s) {
        Gender gender = findGender(s);
        if (gender != null)this.genders.remove(gender);
    }

    @Override
    public Set<Gender> getAll() {
        return this.genders;
    }
}
