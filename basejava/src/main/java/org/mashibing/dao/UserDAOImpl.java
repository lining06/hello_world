package org.mashibing.dao;

import org.mashibing.model.User;

public class UserDAOImpl implements UserDAO {

    @Override
    public void save(User user) {
        System.out.println("save user success");
    }
}
