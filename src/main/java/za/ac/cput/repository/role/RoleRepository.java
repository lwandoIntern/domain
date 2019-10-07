package za.ac.cput.repository.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.role.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,String> {

}
