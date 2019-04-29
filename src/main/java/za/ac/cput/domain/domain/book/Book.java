package za.ac.cput.domain.domain.book;

import za.ac.cput.domain.domain.authors.Author;
import za.ac.cput.domain.domain.publishers.Publisher;

import javax.persistence.Entity;



public interface Book {

     String getIsbnNum();

     int getYearPublished();

     String getTitle();

     Author getAuthor();

     Publisher getPublisher();

     String getCategory();

}
