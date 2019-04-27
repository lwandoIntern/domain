package employees;

import interfaces.Address;
import interfaces.Contact;
import interfaces.Names;

public interface Employee extends Names, Contact, Address,Position {
    String getEmployeeId();
}
