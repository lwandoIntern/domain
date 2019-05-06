package za.ac.cput.domain.domain.book;


import za.ac.cput.domain.domain.authors.Author;
import za.ac.cput.domain.domain.publishers.Publisher;

import javax.persistence.Entity;


public class Article implements Book{
    private String datePublished;
    private boolean downloadable;
    private String isbnNum,title,category;
    private Author author;
    private Publisher publisher;
    private int yearPublished;

    private Article(){}
    public Article(ArticleBuilder builder){
        this.isbnNum = builder.isbnNum;
        this.title = builder.title;
        this.author = builder.author;
        this.category = builder.category;
        this.downloadable = builder.downloadable;
        this.publisher = builder.publisher;
        this.datePublished = builder.datePublished;
        this.yearPublished = builder.yearPublished;
    }
    public static class ArticleBuilder{
        private String datePublished;
        private boolean downloadable;
        private String isbnNum,title,category;
        private Author author;
        private Publisher publisher;
        private int yearPublished;

        public ArticleBuilder datePublished(String datePublished){
            this.datePublished = datePublished;
            return this;
        }
        public ArticleBuilder downloadable(boolean downloadable){
            this.downloadable = downloadable;
            return this;
        }
        public ArticleBuilder isbnNum(String isbnNum){
            this.isbnNum = isbnNum;
            return this;
        }
        public ArticleBuilder title(String title){
            this.title = title;
            return this;
        }
        public ArticleBuilder category(String category){
            this.category = category;
            return this;
        }
        public ArticleBuilder author(Author author){
            this.author = author;
            return this;
        }
        public ArticleBuilder publisher(Publisher p){
            this.publisher = p;
            return this;
        }
        public ArticleBuilder yearPublished(int yearPublished){
            this.yearPublished = yearPublished;
            return this;
        }
        public Article build(){
            return new Article(this);
        }
    }
    @Override
    public String getIsbnNum() {
        return isbnNum;
    }

    @Override
    public int getYearPublished() {
        return yearPublished;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public Author getAuthor() {
        return author;
    }

    @Override
    public Publisher getPublisher() {
        return publisher;
    }

    @Override
    public String getCategory() {
        return category;
    }

    public String getDatePublished() {
        return datePublished;
    }

    public boolean isDownloadable() {
        return downloadable;
    }
}
