package org.mashibing.service;

import org.mashibing.dao.UserDAO;
import org.mashibing.model.User;


/**
 * 模仿spring写的依赖输入
 */

public class UserService {
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    private UserDAO userDAO;

    public void addUser(User user){
        userDAO.save(user);
    }
}
