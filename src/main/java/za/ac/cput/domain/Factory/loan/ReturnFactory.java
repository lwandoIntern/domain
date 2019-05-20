package za.ac.cput.domain.Factory.loan;

import za.ac.cput.domain.domain.book.Book;
import za.ac.cput.domain.domain.loan.Return;
import za.ac.cput.domain.domain.member.Member;

public class ReturnFactory {
    public static Return createReturn(Book book, Member member){
        return new Return.Builder()
                .book(book)
                .member(member)
                .build();
    }
}
