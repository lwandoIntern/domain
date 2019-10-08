package za.ac.cput.service.books.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
    public Category getByCategoryName(String categoryName) {
        return this.categoryRepository.findAll().stream()
                .filter(category -> category.getCategoryName().equalsIgnoreCase(categoryName))
                .findAny()
                .get();
    }

    @Override
    public Category create(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Category read(String s) {
        return this.categoryRepository.getOne(s);
    }

    @Override
    public Category update(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public void delete(String s) {
        this.categoryRepository.deleteById(s);
    }

    @Override
    public Set<Category> getAll() {
        Set<Category> set = new HashSet<>();
        set.addAll(this.categoryRepository.findAll());
        return set;
    }
}
