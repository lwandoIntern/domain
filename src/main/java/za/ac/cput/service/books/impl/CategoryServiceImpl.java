package za.ac.cput.service.books.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.books.Category;
import za.ac.cput.repository.books.CategoryRepository;
import za.ac.cput.service.books.CategoryService;

import java.util.HashSet;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {
    private static CategoryService categoryService = null;
    @Autowired
    private CategoryRepository categoryRepository;

    private CategoryServiceImpl(){}

    public static CategoryService getCategoryService() {
        if (categoryService == null)categoryService = new CategoryServiceImpl();
        return categoryService;
    }

    @Override
    public Category create(Category category) {
        this.categoryRepository.save(category);
        return this.categoryRepository.getOne(category.getCategoryId());
    }

    @Override
    public Category read(String s) {
        return this.categoryRepository.getOne(s);
    }

    @Override
    public Category update(Category category) {
        Category category1 = this.categoryRepository.getOne(category.getCategoryId());
        if (category1 == category){
            this.categoryRepository.delete(category1);
            this.categoryRepository.save(category);
            return this.categoryRepository.getOne(category.getCategoryId());
        }
        return null;
    }

    @Override
    public void delete(String s) {
        this.categoryRepository.deleteById(s);
    }

    @Override
    public Set<Category> getAll() {
        Set<Category> categories = new HashSet<>();
        categories.addAll(this.categoryRepository.findAll());
        return categories;
    }

    @Override
    public Category getByCategoryName(String categoryName) {
        return getAll().stream()
                .filter(category -> category.getCategoryName().equalsIgnoreCase(categoryName))
                .findAny()
                .get();
    }
}
