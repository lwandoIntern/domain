package za.ac.cput.domain.domain.employees;

import za.ac.cput.domain.domain.interfaces.Address;
import za.ac.cput.domain.domain.interfaces.Contact;
import za.ac.cput.domain.domain.interfaces.Names;

public interface Employee extends Names, Contact, Address,Position {
    String getEmployeeId();
}
