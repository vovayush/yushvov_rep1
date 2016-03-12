package com.yush.dao;

import com.yush.entity.User;
import com.yush.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

public class UsersDAOImpl extends GenericDAO implements UsersDAO {
    private static final Logger log = Logger.getLogger(ProductsDAOImpl.class);

    public UsersDAOImpl() {
    }


/*
    public int insert(User user) {
        boolean result = false;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("Problem with insert" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result ? 1 : 0;
    }
*/

    public User getByID(long key) {
        User user = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            user = (User) session.load(User.class, key);
        } catch (HibernateException e) {
            log.error("Problem with get product by id" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return user;
    }

/*
    public void update(User user) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("Problem with update" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
*/

/*
    public void delete(User user) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("Problem with delete" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
*/

    public List<User> getAll() {
        List<User> userList = new ArrayList<User>();
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            userList = session.createCriteria(User.class).list();
        } catch (HibernateException e) {
            log.error("Problem with getAll" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return userList;
    }

    public User getByLogin(String login) {
        User user = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(User.class);
            user = (User) criteria.add(Restrictions.eq("login", login)).uniqueResult();
        } catch (HibernateException e) {
            log.error("Problem with getAll" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return user;
    }
}
