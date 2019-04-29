package za.ac.cput.domain.repository.book_repository;

import za.ac.cput.domain.domain.book.Book;
import za.ac.cput.domain.repository.Repository;

import java.util.List;

public interface BookRepository extends Repository<Book,String> {
    List<Book> getAll();
}
