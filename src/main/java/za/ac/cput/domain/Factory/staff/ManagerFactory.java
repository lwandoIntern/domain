package za.ac.cput.domain.Factory.staff;

import za.ac.cput.domain.domain.employees.Employee;
import za.ac.cput.domain.domain.employees.Manager;
import za.ac.cput.domain.util.Misc;

public class ManagerFactory {
    public static Employee createManager(String nm,String ls,String cell,String tel,int zip,String suburb,String city,
                                         String prov,String role,boolean hasSub,boolean hasSuper){
        return new Manager.Builder()
                .employeeId(Misc.generateId())
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
