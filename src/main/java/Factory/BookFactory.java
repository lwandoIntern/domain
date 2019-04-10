package Factory;

import model.Book;

public class BookFactory {
    public static Book createBook(String id,String author,String title,String edition,int yearP){
        return new Book.Builder()
                .isbn(id)
                .author(author)
                .title(title)
                .edition(edition)
                .yearPublished(yearP)
                .build();
    }

}
