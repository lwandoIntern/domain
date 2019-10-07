package za.ac.cput.service.loan.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.loan.Borrow;
import za.ac.cput.repository.loan.BorrowRepository;
import za.ac.cput.service.loan.BorrowService;


import java.util.HashSet;
import java.util.Set;

@Service
public class BorrowServiceImpl implements BorrowService {
    private static BorrowService borrowService = null;
    @Autowired
    private BorrowRepository borrowRepository;

    private BorrowServiceImpl(){}

    public static BorrowService getBorrowService() {
        if (borrowService == null)borrowService = new BorrowServiceImpl();
        return borrowService;
    }

    @Override
    public Borrow create(Borrow borrow) {
        this.borrowRepository.save(borrow);
        return this.borrowRepository.getOne(borrow.getLoanId());
    }

    @Override
    public Borrow read(String s) {
        return this.borrowRepository.getOne(s);
    }

    @Override
    public Borrow update(Borrow borrow) {
        Borrow borrow1 = read(borrow.getLoanId());
        if (borrow1 == borrow){
            this.borrowRepository.delete(borrow1);
            this.borrowRepository.save(borrow);
            return this.borrowRepository.getOne(borrow.getLoanId());
        }
        return null;
    }

    @Override
    public void delete(String s) {
        this.borrowRepository.deleteById(s);
    }

    @Override
    public Set<Borrow> getAll() {
        Set<Borrow> borrows = new HashSet<>();
        borrows.addAll(this.borrowRepository.findAll());
        return borrows;
    }

    @Override
    public Borrow getByLoanDesc(String loanDesc) {
        return getAll().stream()
                .filter(borrow -> borrow.getLoanDesc().equalsIgnoreCase(loanDesc))
                .findAny()
                .get();
    }
}
