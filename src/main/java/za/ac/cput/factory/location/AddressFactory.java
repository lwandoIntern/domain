package za.ac.cput.factory.location;

import za.ac.cput.domain.location.Address;
import za.ac.cput.util.Helper;

public class AddressFactory {

    public static Address createAddress(String town,String city,int zipCode){

        return new Address.Builder()

                .town(town)
                .city(city)
                .zipCode(zipCode)
                .build();
    }
}
