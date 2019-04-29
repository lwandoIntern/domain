package za.ac.cput.domain.Factory.books;

import za.ac.cput.domain.domain.book.Book;
import za.ac.cput.domain.domain.book.HardCopy;

public class HardCopyFactory {
    public static Book createHardCopy(boolean ysNo){
        return new HardCopy.Builder()
                .availableForLoan(ysNo)
                .build();
    }
}
