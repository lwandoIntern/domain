package za.ac.cput.factory.role;

import za.ac.cput.domain.role.Role;
import za.ac.cput.util.Helper;

public class RoleFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(RoleFactory.class);
    public static Role createRole(String roleDesc){
        String id = Helper.generateRandomGivenSuffix(SUFFIX);
        return new Role.Builder()
                .roleId(id)
                .roleType(roleDesc)
                .build();
    }
}
