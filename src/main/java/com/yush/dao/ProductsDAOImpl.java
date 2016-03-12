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