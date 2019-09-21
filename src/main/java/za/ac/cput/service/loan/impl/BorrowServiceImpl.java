package za.ac.cput.service.loan.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.loan.Borrow;
import za.ac.cput.repository.loan.BorrowRepository;
import za.ac.cput.repository.loan.impl.BorrowRepositoryImpl;
import za.ac.cput.service.loan.BorrowService;

import java.util.Set;

@Service
public class BorrowServiceImpl implements BorrowService {
    private static BorrowService borrowService = null;
    private BorrowRepository borrowRepository;

    private BorrowServiceImpl(){
        this.borrowRepository = BorrowRepositoryImpl.getBorrowRepository();
    }

    public static BorrowService getBorrowService() {
        if (borrowService == null)borrowService = new BorrowServiceImpl();
        return borrowService;
    }

    @Override
    public Borrow create(Borrow borrow) {
        return this.borrowRepository.create(borrow);
    }

    @Override
    public Borrow read(String s) {
        return this.borrowRepository.read(s);
    }

    @Override
    public Borrow update(Borrow borrow) {
        return this.borrowRepository.update(borrow);
    }

    @Override
    public void delete(String s) {
        this.borrowRepository.delete(s);
    }

    @Override
    public Set<Borrow> getAll() {
        return this.borrowRepository.getAll();
    }

    @Override
    public Borrow getByLoanDesc(String loanDesc) {
        return this.borrowRepository.getByLoanDesc(loanDesc);
    }
}
