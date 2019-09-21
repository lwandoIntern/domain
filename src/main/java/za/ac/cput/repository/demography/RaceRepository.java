package za.ac.cput.repository.demography;

import za.ac.cput.domain.demography.Race;
import za.ac.cput.repository.IRepository;

public interface RaceRepository extends IRepository<Race,String> {
    Race getByDesc(String desc);
}
