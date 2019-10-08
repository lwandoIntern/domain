package za.ac.cput.factory.books;

import za.ac.cput.domain.books.BookCategory;

public class BookCategoryFactory {
    public static BookCategory createBookCategory(String isbn, String categoryId){
        return new BookCategory(categoryId,isbn);
    }
}
