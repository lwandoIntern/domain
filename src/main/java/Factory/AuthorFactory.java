package Factory;

import authors.Author;

public class AuthorFactory {
    public static Author createAuthor(String name, String surname, String cell, String tell, int zip, String suburb,
                                      String city, String province,int numOfBooks){
        return new Author.Builder()
                .name(name)
                .surname(surname)
                .cellphone(cell)
                .telephone(tell)
                .zipCode(zip)
                .suburb(suburb)
                .city(city)
                .province(province)
                .numOfBooksWritten(numOfBooks)
                .build();
    }
}
