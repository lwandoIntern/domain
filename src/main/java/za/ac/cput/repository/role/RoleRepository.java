package za.ac.cput.repository.role;

import za.ac.cput.domain.role.Role;
import za.ac.cput.repository.IRepository;

public interface RoleRepository extends IRepository<Role,String> {
    Role getRoleType(String type);
}
