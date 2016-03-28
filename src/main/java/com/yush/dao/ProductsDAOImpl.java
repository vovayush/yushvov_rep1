package com.yush.dao;

import com.yush.entity.Product;
import org.apache.log4j.Logger;

import java.util.List;

public class ProductsDAOImpl extends GenericDAO implements ProductsDAO {
    private static final Logger LOG = Logger.getLogger(ProductsDAOImpl.class);

    public ProductsDAOImpl() {
    }

    public Product getByID(long key) {
        Product product = (Product)super.getByID(key, Product.class);
        return product;
    }

    public List<Product> getAll() {
        super.setEntityClass(Product.class);
        List<Product> productList = super.getAll(Product.class);
        return productList;
    }
}