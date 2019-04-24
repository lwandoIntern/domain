package za.ac.cput.domain.Factory;

import sysemAccess.Register;

public class RegisterFactory {
    public static Register createRegister(String name,String surname,String cell,String tell,int zip,String town,String city,
                                          String province){
        return new Register.Builder()
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
