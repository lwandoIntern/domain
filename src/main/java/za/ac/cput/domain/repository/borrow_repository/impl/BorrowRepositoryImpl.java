package za.ac.cput.domain.repository.borrow_repository.impl;

import borrowingProccess.Borrow;
import za.ac.cput.domain.repository.borrow_repository.BorrowRepository;

import java.util.ArrayList;
import java.util.List;

public class BorrowRepositoryImpl implements BorrowRepository {
    private static BorrowRepositoryImpl repository = null;
    private List<Borrow> borrows;

    private BorrowRepositoryImpl(){
        this.borrows = new ArrayList<>();
    }

    public static BorrowRepositoryImpl getRepository() {
        if (repository == null)repository = new BorrowRepositoryImpl();
        return repository;
    }

    @Override
    public Borrow create(Borrow borrow) {
        repository.borrows.add(borrow);
        int x = borrows.indexOf(borrow);
        return borrows.get(x);
    }

    @Override
    public Borrow read(Borrow borrow) {
        int x = borrows.indexOf(borrow);
        return repository.borrows.get(x);
    }

    @Override
    public Borrow update(Borrow borrow) {
        repository.borrows.add(borrow);
        int x = borrows.indexOf(borrow);
        return repository.borrows.get(x);
    }

    @Override
    public void delete(String s) {
        repository.borrows.remove(s);
    }
}
