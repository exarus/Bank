package com.blogspot.wowguardian.database.dao;

import com.blogspot.wowguardian.database.entity.ExchangeRate;

/**
 * Created by User on 20.07.2014.
 */
public class ExchangeRateDAO extends DAOImpl<ExchangeRate> {

    public static ExchangeRateDAO getInstance() {
        return instance;
    }

    private ExchangeRateDAO() {
        super(ExchangeRate.class);
    }

    private static final ExchangeRateDAO instance = new ExchangeRateDAO();
}
