package za.ac.cput.factory.role;

import za.ac.cput.domain.role.Role;
import za.ac.cput.util.Helper;

public class RoleFactory {

    public static Role createRole(String roleDesc){

        return new Role.Builder()

                .roleType(roleDesc)
                .build();
    }
}
