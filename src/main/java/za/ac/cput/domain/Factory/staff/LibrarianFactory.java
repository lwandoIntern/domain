package za.ac.cput.domain.Factory.staff;

import za.ac.cput.domain.domain.employees.Employee;
import za.ac.cput.domain.domain.employees.Librarian;
import za.ac.cput.domain.util.Misc;

public class LibrarianFactory {
    public static Employee createLibrarian(String nm,String snm,String cell,String tell,String town,String city,int zip,String prov,boolean hasAssist){
        return new Librarian.Builder()
                .employeeId(Misc.generateId())
                .name(nm)
                .surname(snm)
                .cellphone(cell)
                .telephone(tell)
                .suburb(town)
                .city(city)
                .zipCode(zip)
                .province(prov)
                .hasAssistant(hasAssist)
                .build();
    }
}
