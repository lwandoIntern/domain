package book;

public class Article extends Book{
    private String datePublished;
    private boolean downloadable;

    public Article(Builder builder) {
        super(builder);
        this.datePublished = builder.datePublished;
        this.downloadable = builder.downloadable;
    }

    public String getDatePublished() {
        return datePublished;
    }
    public boolean isDownloadable(){
        return downloadable;
    }

    public static class Builder extends Book.Builder{
        private String datePublished;
        private boolean downloadable;

        public Builder datePublished(String val){
            this.datePublished = val;
            return this;
        }
        public Builder downloadable(boolean val){
            this.downloadable = val;
            return this;
        }
        public Builder copy(Article article){
            this.datePublished = article.datePublished;
            this.downloadable = article.downloadable;
            return this;
        }
        public Article build(){
            return new Article(this);
        }
    }
}
