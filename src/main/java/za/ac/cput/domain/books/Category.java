package za.ac.cput.domain.books;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Category implements Serializable {
    @Id
    @Column(name = "category_id")
    private String categoryId;
    @Column(name = "category_name")
    private String categoryName;
    @Column(name = "number_of_books_in_category")
    private int numOfBooksInCategory;

    private Category(){}
    public Category(Builder builder) {
        this.categoryId = builder.categoryId;
        this.categoryName = builder.categoryName;
        this.numOfBooksInCategory = builder.numOfBooksInCategory;

    }

    public int getNumOfBooksInCategory() {
        return numOfBooksInCategory;
    }
    public String getCategoryId() {
        return categoryId;
    }
    public String getCategoryName() {
        return categoryName;
    }
    @Override
    public String toString() {
        return "Category{" +
                "categoryId='" + categoryId + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", numOfBooksInCategory=" + numOfBooksInCategory +
                '}';
    }

    public static class Builder{
        private String categoryId,categoryName;
        private int numOfBooksInCategory;
        public Builder categoryId(String id){
            this.categoryId = id;
            return this;
        }
        public Builder categoryName(String name){
            this.categoryName = name;
            return this;
        }
        public Builder numOfBooksInCategory(int booksInCateg){
            this.numOfBooksInCategory = booksInCateg;
            return this;
        }
        public Category build(){
            return new Category(this);
        }
    }
}
