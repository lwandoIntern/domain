package za.ac.cput.domain.services.loan.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.domain.loan.Borrow;
import za.ac.cput.domain.repository.loan.BorrowRepository;
import za.ac.cput.domain.services.loan.BorrowService;

@Service
public class BorrwServiceImpl implements BorrowService {

    @Autowired
    private BorrowRepository repository;

    @Override
    public Borrow create(Borrow borrow) {
        return this.repository.create(borrow);
    }

    @Override
    public Borrow update(Borrow borrow) {
        return this.repository.update(borrow);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Borrow read(Borrow borrow) {
        return this.repository.read(borrow);
    }
}
