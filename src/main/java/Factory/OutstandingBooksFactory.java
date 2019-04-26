package Factory;

import book.Book;
import borrowingProccess.OutstandingBooks;
import members.Member;

import java.util.ArrayList;

public class OutstandingBooksFactory {
    public static OutstandingBooks createOwed(ArrayList<Book> books, ArrayList<Member> members){
        return new OutstandingBooks.Builder()
                .books(books)
                .members(members)
                .build();
    }
}
