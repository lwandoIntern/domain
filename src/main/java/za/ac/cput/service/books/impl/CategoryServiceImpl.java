package za.ac.cput.service.books.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.books.Category;
import za.ac.cput.repository.books.CategoryRepository;
import za.ac.cput.repository.books.impl.CategoryRepositoryImpl;
import za.ac.cput.service.books.CategoryService;


import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {
    private static CategoryService categoryService = null;
    private CategoryRepository categoryRepository;

    private CategoryServiceImpl(){
        this.categoryRepository = CategoryRepositoryImpl.getCategoryRepository();
    }

    public static CategoryService getCategoryService() {
        if (categoryService == null)categoryService = new CategoryServiceImpl();
        return categoryService;
    }

    @Override
    public Category create(Category category) {
        return this.categoryRepository.create(category);
    }

    @Override
    public Category read(String s) {
        return this.categoryRepository.read(s);
    }

    @Override
    public Category update(Category category) {
        return this.categoryRepository.update(category);
    }

    @Override
    public void delete(String s) {
        this.categoryRepository.delete(s);
    }

    @Override
    public Set<Category> getAll() {
        return this.categoryRepository.getAll();
    }

    @Override
    public Category getByCategoryName(String categoryName) {
        return this.categoryRepository.getByCategoryName(categoryName);
    }
}
