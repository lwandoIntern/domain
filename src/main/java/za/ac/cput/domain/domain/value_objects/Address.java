package za.ac.cput.domain.domain.value_objects;

public final class Address {
    private final int zipCode;
    private final String surbub;
    private final String town;

    public Address(int zipCode, String surbub, String town){
        this.zipCode = zipCode;
        this.surbub = surbub;
        this.town = town;
    }

    public String getTown() {
        return town;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getSurbub() {
        return surbub;
    }
}
