package Factory;

import book.Book;
import book.SoftCopy;

public class SoftCopyFactory {
    public static Book createSoftCopy(boolean canDown){
        return new SoftCopy.Builder()
                .downloadable(canDown)
                .build();
    }
}