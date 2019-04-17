package book;

public class HardCopy extends Book{
    private boolean availableForLoan;

    public HardCopy(Builder builder) {
        super(builder);
    }

    public boolean isAvailableForLoan() {
        return availableForLoan;
    }

    public static class Builder extends Book.Builder{
        private boolean availableForLoan;

        public Builder availableForLoan(boolean val){
            this.availableForLoan = val;
            return this;
        }
        public Builder copy(HardCopy hardCopy){
            this.availableForLoan = hardCopy.availableForLoan;
            return this;
        }
        public HardCopy build(){
            return new HardCopy(this);
        }
    }
}
