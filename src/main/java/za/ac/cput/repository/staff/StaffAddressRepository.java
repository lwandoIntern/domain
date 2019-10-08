package za.ac.cput.repository.staff;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.staff.StaffAddress;

@Repository
public interface StaffAddressRepository extends JpaRepository<StaffAddress,String> {
}
