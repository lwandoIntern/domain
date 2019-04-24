package book;

public class SoftCopy extends Book{
    private boolean downloadable;

    public SoftCopy(Builder builder) {
        super(builder);
        this.downloadable = builder.downloadable;
    }

    public boolean isDownloadable() {
        return downloadable;
    }

    public static class Builder extends Book.Builder{
        private boolean downloadable;

        public Builder downloadable(boolean val){
            this.downloadable = val;
            return this;
        }
        public Builder copy(SoftCopy softCopy){
            this.downloadable = softCopy.downloadable;
            return this;
        }
        public SoftCopy build(){
            return new SoftCopy(this);
        }
    }


}
