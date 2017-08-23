package com.blogspot.wowguardian.database.entity;


import javax.persistence.*;
import java.math.BigInteger;

/**
 * Represents a bank transaction.
 * Created by User on 19.07.2014.
 */
@Entity
@Table(name = "Transactions")
public class Transaction implements HasId {

    @Id
    @GeneratedValue
    @Override
    public BigInteger getId() {
        return id;
    }

    @ManyToOne
    public User getSender() {
        return sender;
    }

    @ManyToOne
    public User getReceiver() {
        return receiver;
    }

    @Column(name = "operation_code")
    public long getOperationCode() {
        return operationCode;
    }

    @Override
    public void setId(BigInteger id) {
        this.id = id;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public void setOperationCode(long operationCode) {
        this.operationCode = operationCode;
    }

    private User sender;
    private User receiver;
    private long operationCode;
    private BigInteger id;
}
