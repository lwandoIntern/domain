package za.ac.cput.domain.Factory;

import book.Book;
import borrowingProccess.Borrow;
import members.Member;

public class BorrowFactory {
    public static Borrow createLoan(String id, Book book, Member member){
        return new Borrow.Builder()
                .loanId(id)
                .book(book)
                .member(member)
                .build();
    }
}
