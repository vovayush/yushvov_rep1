package com.yush.util;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    private static final Logger log = Logger.getLogger(HibernateUtil.class);
    private static SessionFactory sessionFactory = null;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException e) {
            log.error("Problem with Hibernate sessionFactory load" + e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
