package za.ac.cput.domain.Factory.books;

import za.ac.cput.domain.domain.book.Book;
import za.ac.cput.domain.domain.book.SoftCopy;

public class SoftCopyFactory {
    public static Book createSoftCopy(boolean canDown){
        return new SoftCopy.SoftCopyBuilder()
                .downloadable(canDown)
                .build();
    }
}
