package book;

import authors.Author;
import org.springframework.data.repository.CrudRepository;
import publishers.Publisher;





public interface Book {

     String getIsbnNum();

     int getYearPublished();

     String getTitle();

     Author getAuthor();

     Publisher getPublisher();

     String getCategory();

}
