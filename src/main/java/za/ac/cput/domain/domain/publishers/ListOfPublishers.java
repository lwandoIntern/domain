package za.ac.cput.domain.domain.publishers;

import java.util.ArrayList;

public class ListOfPublishers {
    private ArrayList<Publisher> publishers;

    private ListOfPublishers(){}
    public ListOfPublishers(Builder builder){

    }

    public ArrayList<Publisher> getPublishers() {
        return publishers;
    }

    public static class Builder{
        private ArrayList<Publisher> publishers;
        public Builder publishers(ArrayList<Publisher> vals){
            this.publishers = vals;
            return this;
        }
        public Builder copy(ListOfPublishers listOfPublishers){
            this.publishers = listOfPublishers.publishers;
            return this;
        }
        public ListOfPublishers build(){
            return new ListOfPublishers(this);
        }
    }

    @Override
    public String toString() {
        return "ListOfPublishers{" +
                "za.ac.cput.domain.domain.publishers=" + publishers +
                '}';
    }
}
