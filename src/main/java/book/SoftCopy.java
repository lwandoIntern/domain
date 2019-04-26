package book;

import authors.Author;
import publishers.Publisher;

import java.util.Objects;

public class SoftCopy implements Book{
    private boolean downloadable;
    private String isbnNum,title,category;
    private Author author;
    private Publisher publisher;
    private int yearPublished;

    public SoftCopy(SoftCopyBuilder builder) {
        this.downloadable = builder.downloadable;
        this.isbnNum = builder.isbnNum;
        this.title = builder.title;
        this.category = builder.category;
        this.author = builder.author;
        this.publisher = builder.publisher;
        this.yearPublished = builder.yearPublished;
    }

    public static class SoftCopyBuilder{
        private boolean downloadable;
        private String isbnNum,title,category;
        private Author author;
        private Publisher publisher;
        private int yearPublished;

        SoftCopyBuilder isbnNum(String id){
            this.isbnNum = id;
            return this;
        }
        SoftCopyBuilder title(String tit){
            this.title = tit;
            return this;
        }
        SoftCopyBuilder category(String cat){
            this.category = cat;
            return this;
        }
        SoftCopyBuilder author(Author author){
            this.author = author;
            return this;
        }
        SoftCopyBuilder publisher(Publisher publisher){
            this.publisher = publisher;
            return this;
        }
        SoftCopyBuilder yearPublished(int yearPublished){
            this.yearPublished = yearPublished;
            return this;
        }
        SoftCopyBuilder downloadable(boolean isDownloadable){
            this.downloadable = isDownloadable;
            return this;
        }
        SoftCopy build(){
            return new SoftCopy(this);
        }
    }

    @Override
    public String getIsbnNum() {
        return null;
    }

    @Override
    public int getYearPublished() {
        return 0;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public Author getAuthor() {
        return null;
    }

    @Override
    public Publisher getPublisher() {
        return null;
    }

    @Override
    public String getCategory() {
        return null;
    }
    public boolean isDownloadable() {
        return downloadable;
    }
    @Override
    public String toString() {
        return "SoftCopy{" +
                "downloadable=" + downloadable +
                ", isbnNum='" + isbnNum + '\'' +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", author=" + author +
                ", publisher=" + publisher +
                ", yearPublished=" + yearPublished +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SoftCopy softCopy = (SoftCopy) o;
        return downloadable == softCopy.downloadable;
    }

    @Override
    public int hashCode() {
        return Objects.hash(downloadable);
    }
}
