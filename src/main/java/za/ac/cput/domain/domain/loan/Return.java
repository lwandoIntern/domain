package za.ac.cput.domain.domain.loan;

import za.ac.cput.domain.domain.book.Book;
import za.ac.cput.domain.domain.member.Member;

import java.util.Objects;


public class Return {
    private String id;
    private String returnDate;

    private Return(){}
    public Return(Builder builder){

    }

    public String getId() {
        return id;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public static class Builder{
        private String id;
        private String returnDate;

        public Builder id(String id){
            this.id = id;
            return this;
        }
        public Builder returnDate(String returnDate){
            this.returnDate = returnDate;
            return this;
        }
        public Return build(){
            return new Return(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Return aReturn = (Return) o;
        return id.equals(aReturn.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
