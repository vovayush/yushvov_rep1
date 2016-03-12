package com.yush.dao;

import com.yush.entity.Identity;

import java.util.List;

public interface DAO<T> {

    int insert(T entity);

    T getByID(long key);

    void update(T entity);

    void delete(T entity);

    List<T> getAll();
}
