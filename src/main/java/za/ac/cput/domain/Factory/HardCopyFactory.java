package za.ac.cput.domain.Factory;

import book.Book;
import book.HardCopy;

public class HardCopyFactory {
    public static Book createHardCopy(boolean ysNo){
        return new HardCopy.Builder()
                .availableForLoan(ysNo)
                .build();
    }
}
