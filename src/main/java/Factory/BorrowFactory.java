package Factory;

import book.Book;
import borrowingProccess.Borrow;
import members.Member;

public class BorrowFactory {
    public static Borrow createLoan(Book book, Member member){
        return new Borrow.Builder()
                .book(book)
                .member(member)
                .build();
    }
}
