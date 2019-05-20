package za.ac.cput.domain.Factory.loan;

import za.ac.cput.domain.domain.book.Book;
import za.ac.cput.domain.domain.loan.Borrow;
import za.ac.cput.domain.domain.member.Member;
import za.ac.cput.domain.util.Misc;

public class BorrowFactory {
    public static Borrow createLoan(Book book, Member member){
        return new Borrow.Builder()
                .loanId(Misc.generateId())
                .book(book)
                .member(member)
                .build();
    }
}
