package za.ac.cput.repository.books.impl;

import za.ac.cput.domain.books.Category;
import za.ac.cput.repository.books.CategoryRepository;

import java.util.HashSet;
import java.util.Set;

public class CategoryRepositoryImpl implements CategoryRepository {
    private static CategoryRepository categoryRepository = null;
    private Set<Category> categories;

    private CategoryRepositoryImpl(){
        this.categories = new HashSet<>();
    }

    public static CategoryRepository getCategoryRepository() {
        if (categoryRepository == null)categoryRepository = new CategoryRepositoryImpl();
        return categoryRepository;
    }

    private Category findCategory(String id){
        return this.categories.stream()
                .filter(category -> category.getCategoryId().trim().equalsIgnoreCase(id))
                .findAny()
                .orElse(null);
    }
    @Override
    public Category create(Category category) {
        this.categories.add(category);
        return category;
    }

    @Override
    public Category read(String s) {
        Category category = findCategory(s);
        return category;
    }

    @Override
    public Category update(Category category) {
        Category toDelete = findCategory(category.getCategoryId());
        if (toDelete != null){
            this.categories.remove(toDelete);
            return create(category);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        Category category = findCategory(s);
        if (category != null)this.categories.remove(category);
    }

    @Override
    public Set<Category> getAll() {
        return this.categories;
    }

    @Override
    public Category getByCategoryName(String catName) {
        return this.categories.stream().filter(category -> category.getCategoryName().equalsIgnoreCase(catName))
                .findAny()
                .orElse(null);
    }
}
