package za.ac.cput.domain.Factory;

import employees.Employee;
import employees.Librarian;

public class LibrarianFactory {
    public static Employee createLibrarian(String empId,String nm,String snm,String cell,String tell,String town,String city,int zip,String prov,boolean hasAssist){
        return new Librarian.Builder()
                .employeeId(empId)
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
