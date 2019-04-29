package za.ac.cput.domain.Factory.member;

import za.ac.cput.domain.domain.members.Member;
import za.ac.cput.domain.domain.members.RegularMember;

public class RegularMemberFactory {
    public static Member createRegularMember(String name,String surname,String cell,String tel,int zip,String town,
                                                    String city,String prov){
        return new RegularMember.Builder()
                .name(name)
                .surname(surname)
                .cellphone(cell)
                .telephone(tel)
                .zipCode(zip)
                .suburb(town)
                .city(city)
                .province(prov)
                .build();
    }
}
