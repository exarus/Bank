package com.blogspot.wowguardian.database.dao;

import com.blogspot.wowguardian.database.entity.BankAccount;

/**
 * The Database CRUD interface for account management.
 * Created by User on 20.07.2014.
 */
public class BankAccountDAO extends DAOImpl<BankAccount> {

    public static BankAccountDAO getInstance() {
        return instance;
    }

    private BankAccountDAO() {
        super(BankAccount.class);
    }

    private static final BankAccountDAO instance = new BankAccountDAO();
}
