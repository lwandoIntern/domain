package za.ac.cput.domain.services.loan.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.domain.borrowingProccess.Borrow;
import za.ac.cput.domain.repository.borrow_repository.BorrowRepository;
import za.ac.cput.domain.repository.borrow_repository.impl.BorrowRepositoryImpl;
import za.ac.cput.domain.services.loan.BorrowService;

@Service
public class BorrwServiceImpl implements BorrowService {

    private static BorrwServiceImpl service = null;
    private BorrowRepository repository;

    private BorrwServiceImpl(){
        this.repository = BorrowRepositoryImpl.getRepository();
    }
    public static BorrwServiceImpl getService(){
        if (service == null)service = new BorrwServiceImpl();
        return service;
    }
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
