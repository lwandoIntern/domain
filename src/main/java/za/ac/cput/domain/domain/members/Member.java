package za.ac.cput.domain.domain.members;

import za.ac.cput.domain.domain.interfaces.Address;
import za.ac.cput.domain.domain.interfaces.Contact;
import za.ac.cput.domain.domain.interfaces.Names;


public interface Member extends Names,Address,Contact {

    String getMemberId();
}
