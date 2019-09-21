package za.ac.cput.repository.loan;

import za.ac.cput.domain.loan.Borrow;
import za.ac.cput.repository.IRepository;

public interface BorrowRepository extends IRepository<Borrow,String> {
    Borrow getByLoanDesc(String loanDesc);
}
