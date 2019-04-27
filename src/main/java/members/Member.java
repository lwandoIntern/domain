package members;

import interfaces.Address;
import interfaces.Contact;
import interfaces.Names;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;


public interface Member extends Names,Address,Contact {

    String getMemberId();
}
