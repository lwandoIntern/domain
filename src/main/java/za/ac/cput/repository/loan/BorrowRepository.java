package za.ac.cput.repository.loan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.loan.Borrow;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow,String> {

}
