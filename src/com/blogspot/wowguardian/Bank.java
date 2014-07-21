package com.blogspot.wowguardian;

import com.blogspot.wowguardian.database.BankDatabase;
import com.blogspot.wowguardian.database.entity.User;

/**
 * Represents a bank.
 * Created by User on 18.07.2014.
 */
public class Bank {

    public Bank() {
        addExchange();
    }

    public boolean addUser(User user) {
        if (database.getUsers().get(user.getId()) != null) {
            return false;
        }
        database.getUsers().add(user);
        return true;
    }

    public BankDatabase getDatabase() {
        return database;
    }

    public addExchange()

    static {
        database.getExchangeRates();
    }

    private final static BankDatabase database = BankDatabase.getInstance();
}
