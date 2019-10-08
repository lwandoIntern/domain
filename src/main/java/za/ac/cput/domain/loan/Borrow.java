package za.ac.cput.domain.loan;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "loan_id",nullable = false,columnDefinition = "VARCHAR(20)")
    private String loanId;
    private String loanDesc;
    private Date dateBorrowed,dateReturned;

    public Borrow(Builder builder) {
        this.loanId = builder.loanId;
        this.loanDesc = builder.loanDesc;
        this.dateBorrowed = builder.dateBorrowed;
        this.dateReturned = builder.dateReturned;
    }

    public String getLoanDesc() {
        return loanDesc;
    }

    public String getLoanId() {
        return loanId;
    }

    public Date getDateBorrowed() {
        return dateBorrowed;
    }

    public Date getDateReturned() {
        return dateReturned;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "loanId='" + loanId + '\'' +
                ", loanDesc='" + loanDesc + '\'' +
                ", dateBorrowed=" + dateBorrowed +
                ", dateReturned=" + dateReturned +
                '}';
    }
    public static class Builder{
        private String loanId;
        private String loanDesc;
        private Date dateBorrowed,dateReturned;

        public Builder loanId(String loanId){
            this.loanId = loanId;
            return this;
        }
        public Builder loanDesc(String desc){
            this.loanDesc = desc;
            return this;
        }
        public Builder dateBorrowed(Date date){
            this.dateBorrowed = date;
            return this;
        }
        public Builder dateReturned(Date date){
            this.dateReturned = date;
            return this;
        }
        public Borrow build(){
            return new Borrow(this);
        }
    }
}
