package za.ac.cput.service.books.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.books.BookCategory;
import za.ac.cput.repository.books.BookCategoryRepository;
import za.ac.cput.service.books.BookCategoryService;

import java.util.HashSet;
import java.util.Set;

@Service
public class BookCategoryServiceImpl implements BookCategoryService {
    private static BookCategoryService bookCategoryService = null;
    @Autowired
    private BookCategoryRepository bookCategoryRepository;

    private BookCategoryServiceImpl(){

    }

    public static BookCategoryService getBookCategoryService() {
        if (bookCategoryService == null)bookCategoryService = new BookCategoryServiceImpl();
        return bookCategoryService;
    }


    @Override
    public BookCategory create(BookCategory bookCategory) {
        return this.bookCategoryRepository.save(bookCategory);
    }

    @Override
    public BookCategory read(String s) {
        return this.bookCategoryRepository.getOne(s);
    }

    @Override
    public BookCategory update(BookCategory bookCategory) {
        return this.bookCategoryRepository.save(bookCategory);
    }

    @Override
    public void delete(String s) {
        this.bookCategoryRepository.deleteById(s);
    }

    @Override
    public Set<BookCategory> getAll() {
        Set<BookCategory> bookCategories = new HashSet<>();
        bookCategories.addAll(this.bookCategoryRepository.findAll());
        return bookCategories;
    }
}
