package com.blogspot.wowguardian.database.dao;

import com.blogspot.wowguardian.database.entity.Transaction;

/**
 * The Database CRUD interface for transaction management.
 * Created by User on 20.07.2014.
 */
public class TransactionDAO extends DAOImpl<Transaction> {

    public static TransactionDAO getInstance() {
        return instance;
    }

    private TransactionDAO() {
        super(Transaction.class);
    }

    private static final TransactionDAO instance = new TransactionDAO();
}
