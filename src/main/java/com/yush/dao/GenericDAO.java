package com.yush.dao;


import com.yush.entity.Identity;
import com.yush.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public abstract  class GenericDAO<T extends Identity> implements DAO<T> {

    private static final Logger LOG = Logger.getLogger(ProductsDAOImpl.class);
    Session session = null;


    public int insert (T entity) {
        boolean result = false;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            LOG.error("Problem with insert" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result ? 1 : 0;
    }

    public void update(T entity) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            LOG.error("Problem with update" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void delete(T entity) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            LOG.error("Problem with delete" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }


}
