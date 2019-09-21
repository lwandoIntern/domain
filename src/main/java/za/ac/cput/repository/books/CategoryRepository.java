package za.ac.cput.repository.books;

import za.ac.cput.domain.books.Category;
import za.ac.cput.repository.IRepository;

public interface CategoryRepository extends IRepository<Category,String> {
    Category getByCategoryName(String catName);
}
