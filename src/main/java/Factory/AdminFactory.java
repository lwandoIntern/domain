package Factory;

import employees.Admin;
import employees.Employee;

public class AdminFactory {

    public static Employee createAdmin(String nm,String ls,String cell,String tel,int zip,String suburb,String city,
                                         String prov,String role,boolean hasSub,boolean hasSuper){
        return new Admin.Builder()
                .name(nm)
                .surname(ls)
                .cellphone(cell)
                .telephone(tel)
                .zipCode(zip)
                .suburb(suburb)
                .city(city)
                .province(prov)
                .positionName(role)
                .hasSubordinates(hasSub)
                .hasSuperior(hasSuper)
                .build();
    }
}
