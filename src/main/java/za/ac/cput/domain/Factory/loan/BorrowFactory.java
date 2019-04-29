package za.ac.cput.domain.Factory.loan;

import za.ac.cput.domain.domain.book.Book;
import za.ac.cput.domain.domain.borrowingProccess.Borrow;
import za.ac.cput.domain.domain.members.Member;

public class BorrowFactory {
    public static Borrow createLoan(String id, Book book, Member member){
        return new Borrow.Builder()
                .loanId(id)
                .book(book)
                .member(member)
                .build();
    }
}
