package za.ac.cput.service.books;


import za.ac.cput.domain.books.Book;
import za.ac.cput.service.IService;


public interface BookService extends IService<Book,String> {
    Book getByTitle(String bookTitle);
}
