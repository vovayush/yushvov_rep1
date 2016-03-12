package com.yush.dao;

import com.yush.entity.User;

import java.util.List;

public interface UsersDAO extends DAO {

    User getByLogin(String login);

}
