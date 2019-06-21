package za.ac.cput.domain.domain.book;

import za.ac.cput.domain.domain.authors.Author;
import za.ac.cput.domain.domain.publisher.Publisher;


public interface Book {

     String getIsbnNum();

     int getYearPublished();

     String getTitle();

     String getCategory();

}
