package com.blogspot.wowguardian.database.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Represents an user's account in bank.
 * Created by com.blogspot.wowguardian.databas.entity.User on 19.07.2014.
 */
@Entity
@Table(name = "Accounts")
public class BankAccount implements HasId {

    @Id
    @GeneratedValue
    @Column(name = "account_id")
    @Override
    public BigInteger getId() {
        return id;
    }

    @Column(name = "currency")
    public String getCurrency() {
        return currency;
    }

    @Column(name = "value", precision = 2)
    public BigDecimal getValue() {
        return value;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public void setId(BigInteger id) {
        this.id = id;
    }

    private BigInteger id;
    private String currency;
    private BigDecimal value;
}
