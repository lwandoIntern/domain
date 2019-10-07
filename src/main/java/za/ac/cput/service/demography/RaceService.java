package za.ac.cput.service.demography;


import za.ac.cput.domain.demography.Race;
import za.ac.cput.service.IService;

public interface RaceService extends IService<Race,String> {
    Race getByDesc(String s);
}
