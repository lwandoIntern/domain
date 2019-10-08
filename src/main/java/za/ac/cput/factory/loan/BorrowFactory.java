package za.ac.cput.factory.loan;

import za.ac.cput.domain.loan.Borrow;
import za.ac.cput.util.Helper;

import java.util.Date;

public class BorrowFactory {

    public static Borrow createLoan(String desc, Date borrowDate,Date returnDate){

        return new Borrow.Builder()

                .loanDesc(desc)
                .dateBorrowed(borrowDate)
                .dateReturned(returnDate)
                .build();
    }
}
