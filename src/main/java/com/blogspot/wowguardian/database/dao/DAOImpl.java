package com.blogspot.wowguardian.database.dao;

import com.blogspot.wowguardian.database.HibernateUtils;
import com.blogspot.wowguardian.database.entity.HasId;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.math.BigInteger;
import java.util.List;

/**
 * Impl of DAO.
 * Created by User on 20.07.2014.
 */
public class DAOImpl<T extends HasId> implements DAO<T> {

    public DAOImpl(Class<T> tClass) {
        this.tClass = tClass;
    }

    /**
     * READ
     *
     * @param id id
     */
    @Override
    public T get(BigInteger id) {
        Session session = factory.openSession();
        Transaction tx = null;
        T value;
        try{
            tx = session.beginTransaction();
            value = (T) session.get(tClass, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) {
                tx.rollback();
            }
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
        return value;
    }

    @Override
    public List<T> getList() {
        Session session = factory.openSession();
        Transaction tx = null;
        List<T> list;
        try{
            tx = session.beginTransaction();
            list = (List<T>) session.createQuery("FROM " + tClass.getTypeName()).list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) {
                tx.rollback();
            }
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
        return list;
    }

    /**
     * Update
     *
     * @param id id
     * @param newValue other
     */
    @Override
    public boolean update(BigInteger id, T newValue) {
        Session session = factory.openSession();
        Transaction tx = null;
        newValue.setId(id);
        try{
            tx = session.beginTransaction();
            session.update(newValue);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) {
                tx.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    /**
     * Delete
     *
     * @param id id
     */
    @Override
    public boolean delete(BigInteger id) {
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            T value = (T) session.get(tClass, id);
            session.delete(value);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) {
                tx.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    private final Class<T> tClass;
    private final SessionFactory factory = HibernateUtils.getSessionFactory();
}
