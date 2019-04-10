package Factory;

import model.Staff;

public class StaffFactory {
    public static Staff createStaff(String num,String name,String surname,String phone,String address,String role){
        return new Staff.Builder()
                .staffNum(num)
                .name(name)
                .lastName(surname)
                .phone(phone)
                .address(address)
                .role(role)
                .build();
    }
}
