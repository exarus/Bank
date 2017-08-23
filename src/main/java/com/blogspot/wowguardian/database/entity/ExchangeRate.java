package com.blogspot.wowguardian.database.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * The Database CRUD interface for exchange rate management.
 * Created by User on 20.07.2014.
 */
@Entity
@Table(name = "Exchange_rate")
public class ExchangeRate implements HasId {

    @Id
    @GeneratedValue
    @Column(name = "exchange_rate_id")
    @Override
    public BigInteger getId() {
        return id;
    }

    @Column
    public BigDecimal getValue() {
        return value;
    }

    @Column(name = "from_currency")
    public String getFromCurrency() {
        return fromCurrency;
    }

    @Column(name = "to_currency")
    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    @Override
    public void setId(BigInteger id) {
        this.id = id;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    private BigInteger id;
    private String fromCurrency;
    private String toCurrency;
    private BigDecimal value;
}
