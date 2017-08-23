package com.blogspot.wowguardian.database;

import com.blogspot.wowguardian.database.dao.BankAccountDAO;
import com.blogspot.wowguardian.database.dao.ExchangeRateDAO;
import com.blogspot.wowguardian.database.dao.TransactionDAO;
import com.blogspot.wowguardian.database.dao.UserDAO;

/**
 * Represents a bank database.
 * Created by User on 20.07.2014.
 */
public class BankDatabase {

    public static BankDatabase getInstance() {
        return instance;
    }

    public UserDAO getUsers() {
        return users;
    }

    public BankAccountDAO getBankAccounts() {
        return bankAccounts;
    }

    public TransactionDAO getTransactions() {
        return transactions;
    }

    public ExchangeRateDAO getExchangeRates() {
        return exchanges;
    }

    private BankDatabase() {}

    private final static UserDAO users = UserDAO.getInstance();
    private final static BankAccountDAO bankAccounts = BankAccountDAO.getInstance();
    private final static TransactionDAO transactions = TransactionDAO.getInstance();
    private final static ExchangeRateDAO exchanges = ExchangeRateDAO.getInstance();
    private final static BankDatabase instance = new BankDatabase();

}
