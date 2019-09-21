package za.ac.cput.service.role;

import za.ac.cput.domain.role.Role;
import za.ac.cput.service.IService;

public interface RoleService extends IService<Role,String> {
    Role getRoleType(String type);
}
