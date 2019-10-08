package za.ac.cput.service.demography;


import za.ac.cput.domain.demography.Gender;
import za.ac.cput.service.IService;

public interface GenderService extends IService<Gender,String> {
    Gender getByDesc(String s);
}
