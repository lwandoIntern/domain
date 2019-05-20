package za.ac.cput.domain.Factory.loan;

import za.ac.cput.domain.domain.book.Book;
import za.ac.cput.domain.domain.loan.OutstandingBooks;
import za.ac.cput.domain.domain.member.Member;

import java.util.ArrayList;

public class OutstandingBooksFactory {
    public static OutstandingBooks createOwed(ArrayList<Book> books, ArrayList<Member> members){
        return new OutstandingBooks.Builder()
                .books(books)
                .members(members)
                .build();
    }
}
