package za.ac.cput.domain.domain.value_objects;

public final class Contacts {
    private final String cell;
    private final String tell;

    public Contacts(String cell,String tell){
        this.cell = cell;
        this.tell = tell;
    }

    public String getCell() {
        return cell;
    }

    public String getTell() {
        return tell;
    }
}
