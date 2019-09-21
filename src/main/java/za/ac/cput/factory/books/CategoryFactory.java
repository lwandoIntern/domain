package za.ac.cput.factory.books;

import za.ac.cput.domain.books.Category;
import za.ac.cput.util.Helper;

public class CategoryFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(CategoryFactory.class);
    public static Category createCategory(String categoryName,int numOfBooks){
        String id = Helper.generateRandomGivenSuffix(SUFFIX);
        return new Category.Builder()
                .categoryId(id)
                .categoryName(categoryName)
                .numOfBooksInCategory(numOfBooks)
                .build();
    }

}
