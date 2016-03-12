package com.yush.dao;

import com.yush.entity.Identity;
import com.yush.entity.Product;
import com.yush.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class ProductsDAOImpl extends GenericDAO implements ProductsDAO {
    private static final Logger LOG = Logger.getLogger(ProductsDAOImpl.class);
    Session session = null;

    public ProductsDAOImpl() {
    }


/*
    public int insert(Product product) {
        boolean result = false;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(product);
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
*/



    public Product getByID(long key) {
        Product product = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            LOG.debug("session" + session);
            product = (Product) session.load(Product.class, key);
            LOG.debug("product" + product);
        } catch (HibernateException e) {
            LOG.error("Problem with get product by id" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return product;
    }

/*
    public void update(Product product) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(product);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            LOG.error("Problem with update" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
*/

    /*@Override
    public int insert(Identity entity) {
        return super.insert(entity);
    }

    @Override
    public void update(Identity entity) {
        super.update(entity);
    }

    @Override
    public void delete(Identity entity) {
        super.delete(entity);
    }*/
/*
    public void delete(Product product) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(product);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            LOG.error("Problem with delete" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
*/

    public List<Product> getAll() {
        List<Product> productList = new ArrayList<Product>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            productList = session.createCriteria(Product.class).list();
        } catch (HibernateException e) {
            LOG.error("Problem with getAll" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return productList;
    }
}