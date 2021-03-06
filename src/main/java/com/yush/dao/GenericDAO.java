package com.yush.dao;


import com.yush.entity.Identity;
import com.yush.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


public abstract class GenericDAO<T extends Identity> implements DAO<T> {

    private static final Logger LOG = Logger.getLogger(GenericDAO.class);

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void setingSessionFactory(SessionFactory sessionFactory) {
        GenericDAO.sessionFactory = sessionFactory;
    }

    private static SessionFactory sessionFactory;
    private Class<T> entityClass;

    /*static {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }*/
    private Session session;


    protected Session getSession() {
        LOG.debug("sessionFactory = " + sessionFactory);
        session = sessionFactory.getCurrentSession();
        return session != null ? session : sessionFactory.openSession();
    }

    public Class<T> getEntityClass() {
        return entityClass;
    }

    protected Criteria createCriteria() {
        return getSession().createCriteria(entityClass);
    }

    protected String getEntityName() {
        return entityClass.getSimpleName();
    }

    public void setEntityClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public int insert (T entity) {
        boolean result = false;
        try {
/*
            session = HibernateUtil.getSessionFactory().openSession();
*/
            getSession().getTransaction().begin();
            getSession().save(entity);
            getSession().getTransaction().commit();
        } catch (HibernateException e) {
            LOG.error("Problem with insert" + e.getMessage());
        } finally {
           /* if (session != null && session.isOpen()) {
                session.close();
            }*/
        }
        return result ? 1 : 0;
    }

    public void update(T entity) {
        try {
            getSession().getTransaction().begin();
            getSession().update(entity);
            getSession().getTransaction().commit();
        } catch (HibernateException e) {
            LOG.error("Problem with update" + e.getMessage());
        } finally {
           /* if (session != null && session.isOpen()) {
                session.close();
            }*/
        }
    }

    public void delete(T entity) {
        try {
            getSession().getTransaction().begin();

            /*session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();*/
            getSession().delete(entity);
            getSession().getTransaction().commit();

        } catch (HibernateException e) {
            LOG.error("Problem with delete" + e.getMessage());
        } finally {
            /*if (session != null && session.isOpen()) {
                session.close();
            }*/
        }
    }

    public T getByID(long key, Class clazz) {
        T entity = null;
        try {
            //session = HibernateUtil.getSessionFactory().openSession();
            getSession().getTransaction().begin();
            //entity = (T)getSession().get(clazz, key);
            entity = (T)getSession().get(clazz, key);
            LOG.debug("entity = " + entity);
            getSession().getTransaction().commit();
        } catch (HibernateException e) {
            LOG.error("Problem with get product by id" + e.getMessage());
        } finally {
           /* if (session != null && session.isOpen()) {
                session.close();
            }*/
        }
        return entity;
    }

    public List<T> getAll(Class clazz) {
        List<T> list = new ArrayList<T>();
        try {
            LOG.debug("clazz = " + clazz);
            //session = HibernateUtil.getSessionFactory().openSession();
            LOG.debug("session = " + session);
            //session.getTransaction().begin();

            getSession().getTransaction().begin();
            list = createCriteria().setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
            //list = session.createCriteria(clazz).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
            //LOG.debug("list = " + list);
            //LOG.debug("session = " + session);
            getSession().getTransaction().commit();
        } catch (HibernateException e) {
            LOG.error("Problem with getAll" + e.getMessage());
        } finally {
            /*if (session != null && session.isOpen()) {
                session.close();
            }*/
        }
        return list;
    }

}
