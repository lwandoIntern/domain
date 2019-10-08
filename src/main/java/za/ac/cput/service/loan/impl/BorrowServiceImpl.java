package za.ac.cput.service.loan.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.loan.Borrow;
import za.ac.cput.repository.loan.BorrowRepository;

import za.ac.cput.service.loan.BorrowService;

import java.util.HashSet;
import java.util.Set;

@Service
public class BorrowServiceImpl implements BorrowService {
    private static BorrowService borrowService = null;
    private BorrowRepository borrowRepository;

    private BorrowServiceImpl(){}

    public static BorrowService getBorrowService() {
        if (borrowService == null)borrowService = new BorrowServiceImpl();
        return borrowService;
    }

    @Override
    public Borrow getByLoanDesc(String loanDesc) {
        return this.borrowRepository.findAll().stream()
                .filter(borrow -> borrow.getLoanDesc().equalsIgnoreCase(loanDesc))
                .findAny()
                .get();
    }

    @Override
    public Borrow create(Borrow borrow) {
        return this.borrowRepository.save(borrow);
    }

    @Override
    public Borrow read(String s) {
        return this.borrowRepository.getOne(s);
    }

    @Override
    public Borrow update(Borrow borrow) {
        return this.borrowRepository.save(borrow);
    }

    @Override
    public void delete(String s) {
        this.borrowRepository.deleteById(s);
    }

    @Override
    public Set<Borrow> getAll() {
        Set set = new HashSet();
        set.addAll(this.borrowRepository.findAll());
        return set;
    }
}
