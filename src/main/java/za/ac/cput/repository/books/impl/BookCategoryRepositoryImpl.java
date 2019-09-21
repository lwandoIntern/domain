package za.ac.cput.repository.books.impl;

import za.ac.cput.domain.books.BookCategory;
import za.ac.cput.repository.books.BookCategoryRepository;

import java.util.HashSet;
import java.util.Set;

public class BookCategoryRepositoryImpl implements BookCategoryRepository {
    private static BookCategoryRepository bookCategoryRepository = null;
    private Set<BookCategory> bookCategories;

    private BookCategoryRepositoryImpl(){
        this.bookCategories = new HashSet<>();
    }

    public static BookCategoryRepository getBookCategoryRepository() {
        if (bookCategoryRepository == null)bookCategoryRepository = new BookCategoryRepositoryImpl();
        return bookCategoryRepository;
    }
    private BookCategory findBookCategory(String id){
        return this.bookCategories.stream()
                .filter(bookCategory -> bookCategory.getIsbn().trim().equalsIgnoreCase(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public BookCategory create(BookCategory bookCategory) {
        this.bookCategories.add(bookCategory);
        return bookCategory;
    }

    @Override
    public BookCategory read(String s) {
        BookCategory bookCategory = findBookCategory(s);
        return bookCategory;
    }

    @Override
    public BookCategory update(BookCategory bookCategory) {
        BookCategory toDelete = findBookCategory(bookCategory.getIsbn());
        if (toDelete != null){
            this.bookCategories.remove(toDelete);
            return create(bookCategory);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        BookCategory bookCategory = findBookCategory(s);
        if (bookCategory != null)this.bookCategories.remove(bookCategory);
    }

    @Override
    public Set<BookCategory> getAll() {
        return this.bookCategories;
    }
}
