package za.ac.cput.factory.loan;

import za.ac.cput.domain.loan.Borrow;
import za.ac.cput.util.Helper;

import java.util.Date;

public class BorrowFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(BorrowFactory.class);
    public static Borrow createLoan(String desc, Date borrowDate,Date returnDate){
        String id = Helper.generateRandomGivenSuffix(SUFFIX);
        return new Borrow.Builder()
                .loanId(id)
                .loanDesc(desc)
                .dateBorrowed(borrowDate)
                .dateReturned(returnDate)
                .build();
    }
}
