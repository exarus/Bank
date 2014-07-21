package com.blogspot.wowguardian.database.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Set;

/**
 * com.blogspot.wowguardian.databas.entity.User
 * Created by com.blogspot.wowguardian.databas.entity.User on 19.07.2014.
 */
@Entity
@Table(name = "Users")
public class User implements HasId {

    public User() {}

    public User(BigInteger id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    @Override
    public BigInteger getId() {
        return id;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    @OneToMany
    public Set<BankAccount> getAccounts() {
        return accounts;
    }

    @ManyToMany
    public Set<Transaction> getTransactions() {
        return transactions;
    }

    @Override
    public void setId(BigInteger id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAccounts(Set<BankAccount> accounts) {
        this.accounts = accounts;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }


    private BigInteger id;
    private String firstName;
    private String lastName;
    private Set<BankAccount> accounts;
    private Set<Transaction> transactions;
}
