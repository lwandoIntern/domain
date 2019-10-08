package za.ac.cput.service.books;


import za.ac.cput.domain.books.Category;
import za.ac.cput.service.IService;

public interface CategoryService extends IService<Category,String> {
    Category getByCategoryName(String categoryName);
}
