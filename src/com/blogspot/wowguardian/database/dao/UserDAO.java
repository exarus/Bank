package com.blogspot.wowguardian.database.dao;

import com.blogspot.wowguardian.database.entity.User;

/**
 * The Database CRUD interface for users.
 * Created by User on 20.07.2014.
 */
public class UserDAO extends DAOImpl<User> {

    public static UserDAO getInstance() {
        return instance;
    }

    private UserDAO() {
        super(User.class);
    }

    private static final UserDAO instance = new UserDAO();
}
