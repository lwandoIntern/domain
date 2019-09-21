package za.ac.cput.repository.loan.impl;

import za.ac.cput.domain.loan.Borrow;
import za.ac.cput.repository.IRepository;
import za.ac.cput.repository.loan.BorrowRepository;

import java.util.HashSet;
import java.util.Set;

public class BorrowRepositoryImpl implements BorrowRepository {
    private static BorrowRepository borrowRepository = null;
    private Set<Borrow> borrowSet;

    private BorrowRepositoryImpl(){
        this.borrowSet = new HashSet<>();
    }

    public static BorrowRepository getBorrowRepository() {
        if (borrowRepository == null)borrowRepository = new BorrowRepositoryImpl();
        return borrowRepository;
    }
    private Borrow findLoan(String s){
        return this.borrowSet.stream()
                .filter(borrow -> borrow.getLoanId().trim().equalsIgnoreCase(s))
                .findAny()
                .orElse(null);
    }

    @Override
    public Borrow getByLoanDesc(String loanDesc) {
        return this.borrowSet.stream().filter(borrow -> borrow.getLoanDesc().equalsIgnoreCase(loanDesc)).findAny().orElse(null);
    }

    @Override
    public Borrow create(Borrow borrow) {
        this.borrowSet.add(borrow);
        return borrow;
    }

    @Override
    public Borrow read(String s) {
        Borrow borrow = findLoan(s);
        return borrow;
    }

    @Override
    public Borrow update(Borrow borrow) {
        Borrow toDelete = findLoan(borrow.getLoanId());
        if (toDelete != null){
            this.borrowSet.remove( toDelete);
            return create(borrow);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        Borrow borrow = findLoan(s);
        if (borrow != null)this.borrowSet.remove(borrow);
    }

    @Override
    public Set<Borrow> getAll() {
        return this.borrowSet;
    }
}
