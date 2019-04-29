package za.ac.cput.domain.Factory.registration;

import za.ac.cput.domain.domain.sysemAccess.Register;
import za.ac.cput.domain.util.Misc;

public class RegisterFactory {
    public static Register createRegister(String name,String surname,String cell,String tell,int zip,String town,String city,
                                          String province){
        return new Register.Builder()
                .regNum(Misc.generateId())
                .name(name)
                .surname(surname)
                .cellphone(cell)
                .telephone(tell)
                .zipCode(zip)
                .suburb(town)
                .city(city)
                .province(province)
                .build();
    }
}
