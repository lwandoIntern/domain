package za.ac.cput.factory.books;

import za.ac.cput.domain.books.Category;
import za.ac.cput.util.Helper;

public class CategoryFactory {

    public static Category createCategory(String categoryName,int numOfBooks){

        return new Category.Builder()
                .categoryName(categoryName)
                .numOfBooksInCategory(numOfBooks)
                .build();
    }

}
