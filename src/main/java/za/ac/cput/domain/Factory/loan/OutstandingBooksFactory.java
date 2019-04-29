package za.ac.cput.domain.Factory.loan;

import za.ac.cput.domain.domain.book.Book;
import za.ac.cput.domain.domain.borrowingProccess.OutstandingBooks;
import za.ac.cput.domain.domain.members.Member;

import java.util.ArrayList;

public class OutstandingBooksFactory {
    public static OutstandingBooks createOwed(ArrayList<Book> books, ArrayList<Member> members){
        return new OutstandingBooks.Builder()
                .books(books)
                .members(members)
                .build();
    }
}
