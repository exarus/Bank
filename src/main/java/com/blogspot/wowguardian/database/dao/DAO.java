package com.blogspot.wowguardian.database.dao;

import com.blogspot.wowguardian.database.HibernateUtils;
import com.blogspot.wowguardian.database.entity.HasId;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigInteger;
import java.util.List;

/**
 * Data access interface.
 * Created by User on 20.07.2014.
 */
public interface DAO<T extends HasId> {

    /** Create */
    default BigInteger add(T o) {
        Session session = null;
        Transaction tx = null;
        BigInteger id = null;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            tx = session.beginTransaction();
            id = (BigInteger) session.save(o);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return id;
    }

    /** READ */
    T get(BigInteger id);
    //T get(T o);
    List<T> getList();

    default int count() {
        return getList().size();
    }

    /** Update */
    boolean update(BigInteger id, T other);

    /** Delete */
    boolean delete(BigInteger id);
}
