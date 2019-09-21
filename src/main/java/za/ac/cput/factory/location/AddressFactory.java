package za.ac.cput.factory.location;

import za.ac.cput.domain.location.Address;
import za.ac.cput.util.Helper;

public class AddressFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(AddressFactory.class);
    public static Address createAddress(String town,String city,int zipCode){
        String id = Helper.generateRandomGivenSuffix(SUFFIX);
        return new Address.Builder()
                .addressId(id)
                .town(town)
                .city(city)
                .zipCode(zipCode)
                .build();
    }
}
