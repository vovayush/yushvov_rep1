package com.yush.dao;


import com.yush.entity.Identity;
import com.yush.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public abstract class GenericDAO<T extends Identity> implements DAO<T> {

    private static final Logger LOG = Logger.getLogger(ProductsDAOImpl.class);
    private static SessionFactory sessionFactory;
    private Class<T> entityClass;

    static {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }
    private Session session;


    protected Session getSession() {
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
           // session = HibernateUtil.getSessionFactory().openSession();
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
            //session = HibernateUtil.getSessionFactory().openSession();
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
           // session = HibernateUtil.getSessionFactory().openSession();
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

    public T getByID(long key, Class clazz) {
        T entity = null;
        try {
            //session = HibernateUtil.getSessionFactory().openSession();
            getSession().getTransaction().begin();
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
           // session = HibernateUtil.getSessionFactory().openSession();
            LOG.debug("session = " + session);
            getSession().getTransaction().begin();
            list = createCriteria().setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

            LOG.debug("list = " + list);
            LOG.debug("session = " + session);
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
