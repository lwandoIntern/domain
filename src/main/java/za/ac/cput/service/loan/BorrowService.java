package za.ac.cput.service.loan;

import za.ac.cput.domain.loan.Borrow;
import za.ac.cput.service.IService;

public interface BorrowService extends IService<Borrow,String> {
    Borrow getByLoanDesc(String loanDesc);
}
