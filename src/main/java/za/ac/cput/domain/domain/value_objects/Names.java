package za.ac.cput.domain.domain.value_objects;

public final class Names {
    private final String name;
    private final String surname;

    public Names(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
