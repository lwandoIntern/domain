package za.ac.cput.domain.books;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "isbn_number",nullable = false,columnDefinition = "VARCHAR(20)")
    private String categoryId;
    private String categoryName;
    private int numOfBooksInCategory;

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
        private String categoryId;
        private String categoryName;
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
