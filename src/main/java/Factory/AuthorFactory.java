package Factory;

import model.Author;

public class AuthorFactory {
    public static Author createAuthor(int id, String name, String lastName, String address,String phone){
        return new Author.Builder()
                .authId(id)
                .name(name)
                .address(address)
                .lastName(lastName)
                .phone(phone)
                .build();
    }
}
