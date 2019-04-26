package za.ac.cput.domain.Factory;

import book.Book;
import book.SoftCopy;

public class SoftCopyFactory {
    public static Book createSoftCopy(boolean canDown){
        return new SoftCopy.SoftCopyBuilder()
                .downloadable(canDown)
                .build();
    }
}
