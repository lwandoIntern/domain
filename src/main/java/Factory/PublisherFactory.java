package Factory;

import model.Publisher;

public class PublisherFactory {
    public static Publisher createPublisher(String id,String name,String address,String phone){
        return new Publisher.Builder()
                .id(id)
                .name(name)
                .address(address)
                .phone(phone)
                .build();
    }
}
