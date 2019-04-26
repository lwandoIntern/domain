package book;

import authors.Author;
import publishers.Publisher;


import java.util.Objects;



public interface Book {

     String getIsbnNum();

     int getYearPublished();

     String getTitle();

     Author getAuthor();

     Publisher getPublisher();

     String getCategory();

}
