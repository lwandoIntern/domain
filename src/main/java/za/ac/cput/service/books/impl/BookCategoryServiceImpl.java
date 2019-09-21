package za.ac.cput.service.books.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.books.BookCategory;
import za.ac.cput.repository.books.BookCategoryRepository;
import za.ac.cput.repository.books.impl.BookCategoryRepositoryImpl;
import za.ac.cput.service.books.BookCategoryService;

import java.util.HashSet;
import java.util.Set;

@Service
public class BookCategoryServiceImpl implements BookCategoryService {
    private static BookCategoryService bookCategoryService = null;
    private BookCategoryRepository bookCategoryRepository;

    private BookCategoryServiceImpl(){
        this.bookCategoryRepository = BookCategoryRepositoryImpl.getBookCategoryRepository();
    }

    public static BookCategoryService getBookCategoryService() {
        if (bookCategoryService == null)bookCategoryService = new BookCategoryServiceImpl();
        return bookCategoryService;
    }

    @Override
    public BookCategory create(BookCategory bookCategory) {
        return this.bookCategoryRepository.create(bookCategory);
    }

    @Override
    public BookCategory read(String s) {
        return this.bookCategoryRepository.read(s);
    }

    @Override
    public BookCategory update(BookCategory bookCategory) {
        return this.bookCategoryRepository.update(bookCategory);
    }

    @Override
    public void delete(String s) {
        this.bookCategoryRepository.delete(s);
    }

    @Override
    public Set<BookCategory> getAll() {
        return this.bookCategoryRepository.getAll();
    }
}
