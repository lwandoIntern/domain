package za.ac.cput.repository.books;

import za.ac.cput.domain.books.Book;
import za.ac.cput.repository.IRepository;

public interface BookRepository extends IRepository<Book,String> {
    Book getByTitle(String title);
}
