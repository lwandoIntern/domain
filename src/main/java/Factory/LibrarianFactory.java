package Factory;

import employees.Employee;
import employees.Librarian;

public class LibrarianFactory {
    public static Employee createLibrarian(boolean hasAssist){
        return new Librarian.Builder()
                .hasAssistant(hasAssist)
                .build();
    }
}
