package za.ac.cput.repository.demography;

import za.ac.cput.domain.demography.Gender;
import za.ac.cput.repository.IRepository;

public interface GenderRepository extends IRepository<Gender,String> {
    Gender getByDesc(String desc);
}
