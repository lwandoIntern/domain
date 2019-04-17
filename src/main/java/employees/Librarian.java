package employees;

import publishers.ListOfPublishers;

public class Librarian extends Employee{
    private boolean hasAssistant;

    public Librarian(Builder builder) {
        super(builder);
        this.hasAssistant = builder.hasAssistant;
    }

    public boolean isHasAssistant() {
        return hasAssistant;
    }

    public static class Builder extends Employee.Builder{
        private boolean hasAssistant;

        public Builder hasAssistant(boolean value){
            this.hasAssistant = value;
            return this;
        }
        public Builder copy(Librarian librarian){
            this.hasAssistant = librarian.hasAssistant;
            return this;
        }
        public Librarian build(){
            return new Librarian(this);
        }
    }
}
