package com.yush.dao;

import com.yush.entity.User;
import com.yush.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class UsersDAOImpl extends GenericDAO implements UsersDAO {
    private static final Logger LOG = Logger.getLogger(ProductsDAOImpl.class);

    public UsersDAOImpl() {
    }

    public User getByID(long key) {
        User user = (User)getByID(key, User.class);
        return user;
    }

    public List<User> getAll() {
        List<User> userList = super.getAll(User.class);
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
            LOG.error("Problem with getAll" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return user;
    }
}
