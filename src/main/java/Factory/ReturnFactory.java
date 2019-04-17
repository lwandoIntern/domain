package Factory;

import book.Book;
import borrowingProccess.Return;
import members.Member;

public class ReturnFactory {
    public static Return createReturn(Book book, Member member){
        return new Return.Builder()
                .book(book)
                .member(member)
                .build();
    }
}
