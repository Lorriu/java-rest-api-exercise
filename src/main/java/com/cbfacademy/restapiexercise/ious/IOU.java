package com.cbfacademy.restapiexercise.ious;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class IOU {

    private UUID id;
    private String borrower;
    private String lender;
    private BigDecimal amount;
    private Instant dateTime;


    //constructor that should generate a new UUID
    public IOU(String borrower, String lender, BigDecimal amount, Instant dateTime){

        //generate random UUID
        this.id = UUID.randomUUID();
        this.borrower = borrower;
        this.lender = lender;
        this.amount = amount;
        this.dateTime = dateTime;

    }


    //get unique identifier for the IOU
    public UUID getId(){

        return id;
    }
    
    //get name of borrower
    public String getBorrower(){

        return borrower;
    }

    //get name of lender
    public String getLender(){

        return lender;
    }

    //get amount covered by IOU
    public BigDecimal getAmount(){

        return amount;
    }

    //get date and time of IOU being issued
    public Instant getDateTime(){

        return dateTime;
    }

    
    //set ID
    public void setId(UUID id) {
        this.id = id;
    }
    
    //set name of borrower
    public void setBorrower(String borrower){

        this.borrower = borrower;
    }

    //set name of lender
    public void setLender(String lender){

        this.lender = lender;
    }

    //set amount covered by IOU
    public void setAmount(BigDecimal amount){

        this.amount = amount;
    }

    //set date and time of IOU being issued
    public void setDateTime(Instant dateTime){

        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "{" +
                "id:" + id +
                ", borrower:'" + borrower + 
                ", lender:'" + lender +
                ", amount:" + amount +
                ", dateTime:" + dateTime +
                "}";
    }
}
